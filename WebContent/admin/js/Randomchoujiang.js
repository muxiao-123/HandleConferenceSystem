	var ran = 0;
	var range = 0;
	var myNumber;
	/*将产生随机数的方法进行封装*/
	function sjs(range) {
	    ran = Math.random() * range;//[0,range)的随机数
	    var result = parseInt(ran);//将数字转换成整数
	    if (result == 0){
	        return 1;
	    }else {
	        return result;
	    }
	}
	/*对显示随机数的方法进行封装*/
	function showRandomNum() {
	    var figure = sjs(range);
	    $("#choujiangxianshikuai").html(figure);
	}
	    /*点击开始按钮,产生的事件*/
	$("#start").click(function () {
	    range = prompt("请输入参会人员总数：", "20");//总人数加一才能输出总人数，取值范围[0,range)
	    if (range == null){alert("请输入数字");return;}
	    
	    if (range == 0)  {alert("请输入数字");return; }
	    
	    if (isNaN(range))  {alert("请输入数字");return ; }
	      
	        /*将开始标签禁用，停止标签启用*/
	       
	    $("#start")[0].disabled = true;
	    $("#stop")[0].disabled = false;
	    if (range > 9999 || range<-999)
	    {
	        // by 何问起
	        $("#choujiang div").css("font-size", "200px");
	        //return;
	    }
	    myNumber = setInterval(showRandomNum, 50);//多长时间运行一次，单位毫秒
	});
	   
	$("#stop").click(function () {
		
	    /*将开始标签启用，停止标签禁用*/
	    $("#start")[0].disabled = false;
	    $("#stop")[0].disabled = true;
	    clearInterval(myNumber);
	});
