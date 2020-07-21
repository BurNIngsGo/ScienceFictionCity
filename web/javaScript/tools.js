/**
 * 获取元素的指定样式值
 * @param {Object} obj
 * @param {Object} attr
 */
function getStyle(obj,attr){
	return obj.currentStyle ? obj.currentStyle[attr] : window.getComputedStyle(obj,null)[attr];//currentStyle是为了兼容IE浏览器，如果不在IE浏览器的话可以完全返回getComputedStyle
}

/**
 * 在外部设置好li元素的样式则不会有打开时的放大效果
 * 向左向右是由改变size数组元素的位置来实现的
 * @param {Object} obj
 * @param {Object} json
 * @param {Object} fn
 */
function animate(obj,json){
	clearInterval(obj.timer);                           		//清除计时
	/**
	 * 利用leader = (json - leader)/10+leader的公式模拟了一个动态效果计算出来leader会无限逼近json
	 */
	obj.timer=setInterval(function(){                   		//设置计时器
		var bool=true;
		for(var k in json){                             		//利用k获取size数组存储的样式信息
			var leader;											//模拟所有元素样式动画路径的变量
			
			/**
			 * 透明的特殊样式处理
			 */
			if (k=='opacity') {                                 //当遍历到li集合的opacity属性时
				if (getStyle(obj,k)==undefined) {               //获取li的透明样式是否为空，为空则是第一次加载网页
					leader=100;									//设为100表示不需要从0过度到100
				}else {
					leader=parseInt(getStyle(obj,k)*100);		//将获取到的透明样式值*100转换成int（成为一百的倍数，为下方转换更方便）
				}
			}else {
				leader=parseInt(getStyle(obj,k)) || 0;          //获取li元素的k样式值，只要样式值不为0就赋值非0的数
			}
			
			/**
			 * 所有样式的统一过滤公式，从0过滤到size数组记录的样式值（opacity例外）
			 */
			var step=(json[k]-leader)/10;                       //解析：k 为 属性，json[属性]其值为 它的属性值（若json[k]等于leader就代表完成了过度）
			step= step>0 ? Math.ceil(step) : Math.floor(step);  //ceil 向上取整    floor向下取整
			leader=leader+step;                                 //向目标值逼近
			
			/**
			 * 将数据应用到样式中去
			 */
			if(k=='zIndex'){                                    //当遍历到zIdex时
				obj.style[k]=json[k];							//将当前size数组中的zIndex样式应用到实际的li中			
			}else if(k=='opacity'){                             //当遍历到opacity时
				obj.style[k]=leader/100;						//将之化为一百以内
				obj.style.filter='alpha(opacity='+leader+')';   //为了兼容更早的版本，已经证明去掉没有影响						
			}else{
				obj.style[k]=leader+'px';						//除了zIndex和opacity外其他都是以像素为单位的
			}
			
			
			if(json[k]!=leader){                                //若没有将任何一个leader样式值逼近到规定值时则继续重复逼近
				bool=false;
			}
		}
		
		
		if(bool){												//如果上方所有样式都已经逼近到size中记录的大小
			clearInterval(obj.timer);                           //清除计时器
		}
	},5);                                                      //30毫秒
}
