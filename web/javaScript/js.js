window.onload=function(){                  		//网页加载时
    var imgArr=[
        {"path":"assets/siximg.jpg"},           
        {"path":"assets/timg.jpg"},		   
        {"path":"assets/eightimg.jpg"}            
    ];                                          //利用数组对三张图片的路径进行保存
    
    var size=[
        {"top":30,"left":150,"width":450,"height":300,"zIndex":3,"opacity":70},
        {"top":0,"left":290,"width":600,"height":360,"zIndex":4,"opacity":100},  
        {"top":30,"left":570,"width":450,"height":300,"zIndex":3,"opacity":70}   
    ];                                          //利用size保存对li元素的设置，记录的都是位置，层次，透明度等动态相关的参数
    
    
    var imgSum=imgArr.length;					//计算图片的个数（为了方便利用循环为li元素添加背景图片，以及动态创建li元素的个数）
    var wrap=document.getElementById('wrap');	//获取id为wrap的元素
    var cont=wrap.firstElementChild ;			//相当获取id为wrap的第一个子元素（获取ul）
    var conu=document.getElementById('navDiv');	//获取id为navDiv的元素（轮播图下方的导航条div）
    var btnArr=wrap.getElementsByTagName('a');	//获取id为wrap的a元素集合到btnArr数组中
    var falg=true;								//向左向右的按钮总是默认可点击的（也可以不要，我也不知道为什么作者会设这个）
    var speed=3000;                             //在此设置计时器的时间，原因是因为有一个鼠标离开事件设置计时器（鼠标经过清除计时器），还有一个加载网页完毕后开启的计时器（鼠标经过清除计时器）
    
    
    wrap.onmouseover=function(){                //当id为wrap的元素（就是外层的div元素）发生鼠标经过事件
        for (var i=0;i<btnArr.length;i++) {     //当前网页有两个a标签（用a标签有天然的point属性值），故循环两次
            btnArr[i].style.display='block';    //将当前网页的两个a标签设置为块级元素（目的为让他可见，因为在style（css）文件中他的值是none不可见）
        }
        clearInterval(wrap.timer);              //停止计时
    }
    
    
    wrap.onmouseout=function(){                 //当鼠标离开id为wrap（就是外层的div元素）的元素事件
        for (var i=0;i<btnArr.length;i++) {     //当前网页有两个a标签，故循环两次
            btnArr[i].style.display='none';     //隐藏a标签（为了美观还是要隐藏）
        } 
        wrap.timer=setInterval(function(){		//开始计时（设置计时）
             move(true);            			//移动的函数，（下方有定义）
         },speed);                              //事件间隔 speed秒（上方定义的speed的用处）
    }
    
    for (var i=0;i<imgSum;i++) {									 //首先检查图片个数（imgSum开始定义的第一个变量的用处）
        var lis=document.createElement('li');                        //创建li元素
        lis.style.backgroundImage='url('+imgArr[i].path+')';         //将背景图片设置到li中（利用了上方图片数组imgArr中的path后面的值，也就是图片的路径）
        lis.innerHTML = "第"+(i+1)+"名";
        cont.appendChild(lis);                                       //将这个li元素附加到cont后面（cont是前方获取的一个div）
    }
    
    for(var i = 0; i < imgSum; i++){								 //根据图片个数来添加导航条的黑块个数
    	var divs = document.createElement('div');					 //创建div元素（也可以是其他）
    	divs.style.display = 'block';								 //以下51~59都是都是样式定义，可以不定义到这里，直接写到style文件里头
    	divs.style.height = '10px';
    	divs.style.width = '30px';
    	divs.style.float = 'left';
    	divs.style.backgroundColor = '#FCFCFC';
    	divs.style.opacity = '0.2';
    	divs.style.marginRight = '10px';
    	divs.style.cursor = 'pointer';
    	divs.style.transition = '0.5s';
    	conu.appendChild(divs);										 //添加到id为conu后面（conu是前方获取的一个div）
    }
    var navLength=parseInt(window.getComputedStyle(conu,null)['width']);             //获取conu的长度，由于长度带一个px所以要用parseInt方法转换成int
    var centerIndex=parseInt(window.getComputedStyle(wrap,null)['width'])-navLength; //由于最大的div是已经居中的，想要导航条居中就得将最大div得长度减去导航条得长度，再除以2
	conu.style.left = centerIndex/2+'px';       //想要导航条居中就得将最大div的长度减去导航条得长度——>（centerIndex），再除以2,这个就是居中位置
    
    var divArr=conu.children;					//获取conu后的所有子元素集合，在本网页为当行条div的子div元素集合
    var liArr=cont.children;                    //获取cont的所有子元素集合，在本网页为ul的li元素集合
	move();                                     //不带参数则只会放出刚开始的动态效果（从左上角向右下角的过度动画），下方有定义
    wrap.timer=setInterval(function(){          //开始计时（设置计时器）
        move(true);								//移动的函数（speed秒后默认向右），下方有定义
    },speed);								    //事件间隔 speed秒（上方定义的speed的用处，现在可以看出这很统一）
    
    
    btnArr[1].onclick=function(){               //第二个a标签被单击
        if (falg) {								//默认可被点击移动
            move(true);                  		//向右，下方有定义
        }
    }
    btnArr[0].onclick=function(){               //第一个a标签被单击
        if (falg) {								//默认可被点击移动
            move(false);                 		//向左，下方有定义
        }
    }
    
    divArr[0].onmouseover=function(){           //鼠标经过导航条的第一个块
    	divArr[0].style.opacity = '1';			//则不透明
    }
    divArr[1].onmouseover=function(){			//鼠标经过导航条的第二个块
    	divArr[1].style.opacity = '1';			//则不透明
    }
    divArr[2].onmouseover=function(){			//鼠标经过导航条的第二个块
    	divArr[2].style.opacity = '1';			//则不透明
    }
    
    
    divArr[0].style.opacity = '1';              //默认第一张图片显示在最前端，所以第一个导航块不透明（样式文件里设置的是黑色）
    var pri = 0;								//为导航条提供逻辑显示的变量（定义为全局是为了能够被下方的导航条特效再次应用）
    var prv = 0;								//记录导航条上一次显示的位置，以便消除颜色归原
    function move(bool){                 		//移动函数的定义，上方反复调用的核心方法
    	var elem1;								//记录li数组的元素移动
        if(bool!=undefined){                    //如果参数不为空，为空就不会改变数组记录的li位置信息，防止出问题
            if(bool){                           //如果传过来的是true
            	elem1=size.pop();				//pop为删除数组最后的元素并返回该元素
                size.unshift(elem1);  			//unshift为将参数添加到数组的第一位（这就是为什么第一张图片到了最后，再次移动会到第一为的原因）               
            }else {                             //如果传过来的是false
            	elem1=size.shift();				//shift为删除数组第一个元素并返回该元素
                size.push(elem1);        		//unshift为将参数添加到数组的最后一位      
            } //此处并不是真正的移动了真实的li元素，只是改变记录了li数组的其中的元素位置，之后会有animate方法来对真实的 li进行视觉上的操作
        }
        
        if(bool != undefined){
        	if(bool){
	        	divArr[prv].style.opacity = '0.2';	//将上一次导航条的标识块还原成透明
	        	if(++pri > 2) pri = 0;				//向右是自加，如果显示到了最后则回到最前端   0 1 2 0 1 2...
	        	prv = pri;							//将此次显示的位置记录下来，等到下一次用于还原导航块
	        	divArr[pri].style.opacity = '1';  	//将上面处理过的导航块位置显示为不透明（黑色）
			}else{
				divArr[pri].style.opacity = '0.2';  //如果是左移动就将之前右移动的最后位置还原成透明
				if(--pri < 0) pri = 2;              //向左是自减，如果显示到了最前端则回到最后端 2 1 0 2 1 0...
				divArr[pri].style.opacity = '1';    //将上面处理过的导航块位置显示为不透明（黑色）
				prv = pri;							//将此次显示的位置记录下来，用于衔接向右时清除还原最后一次向左的导航块
			}
        }
        
        for (var i=0;i<liArr.length;i++) {     		//循环次数为li元素的个数
            animate(liArr[i],size[i]);				//执行了上方对size数组的操作则会出现滚动效果，若size数组的样式集合都应用到liArr中就不会再有开始的放大动画，该方法的定义中有详细注释
        }
    }
    
    divArr[0].onclick=function(){                   //第一个导航块被单击
    	for(var i = 0; i < pri; i++){				//由于是第一个导航块，所以要显示第一个导航块位置的图片只需要滚动 ：当前图片显示位置（pri:2,1）- 当前当行快位置（0）故为循环移动pri次
    		move(true);								//向右移动，上方有定义
    	}
    }
    divArr[1].onclick=function(){                   //第二个导航块被单击
    	if(pri - 1 < 0)								//如果当前图片显示的是第一张，那么-1会小于零，所以被标识的导航块在第一个位置（当前index位置是1）
    		move(true);								//向右移动，上方有定义
    	else if(pri -1 == 1){						//如果当前图片显示的是第二张，那么-1会等于1，所以被标识的导航块在第三个位置（当前index位置是1）
    		move(true);                             //向右移动两次(第一次)
    		move(true);                             //。。。。(第二次)
    	}
    }
    divArr[2].onclick=function(){                   //第三个导航块被单击
    	if(pri - 2 == -1){							//如果当前图片显示的是第二张，那么-1会小于零，所以被标识的导航块在第二个位置（当前index位置是1）
    		move(true);								//向右移动，上方有定义
    	}else if(pri - 2 == -2){					//如果当前图片显示的是第二张，那么-1会等于-2，所以被标识的导航块在第一个位置（当前index位置是0）
    		move(true);								//向右移动两次(第一次)
    		move(true);    							//。。(第二次)
    	}
    }
    
    
    divArr[0].onmouseout=function(){				//鼠标离开第一个导航块时
    	if(pri != 0)								//只要当前标识的导航块不是第一个
    	divArr[0].style.opacity = '0.2';			//将第一个导航块复原透明
    }
    divArr[1].onmouseout=function(){				//鼠标离开第二个导航块时
    	if(pri != 1)								//只要当前标识的导航块不是第二个
    	divArr[1].style.opacity = '0.2';			//将第二个导航块复原透明
    }
    divArr[2].onmouseout=function(){				//鼠标离开第三个导航块时
    	if(pri != 2)								//只要当前标识的导航块不是第三个
    	divArr[2].style.opacity = '0.2';			//将第三个导航块复原透明
    }
}