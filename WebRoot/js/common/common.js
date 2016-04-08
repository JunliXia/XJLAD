

function changeTrColorone(obj){    

	    var _table=obj.parentNode;

	    for (var i=0;i<_table.rows.length;i++){


	    }    
	    var x=69;
	    var y=205;
	    var z=195;
	    obj.style.backgroundColor=setColor(x, y, z);

	}


var curtab = null;
function do_onclick(tab){
	 if(curtab==tab){
		tab.style.backgroundColor =setColor(232,251,250);
		curtab = null;
	 }else{
		 var x=69;
		 var y=205;
  	     var z=195;
    	 tab.style.backgroundColor = setColor(x, y, z);
    	 
         if(curtab != null) curtab.style.backgroundColor = setColor(232,251,250);
         curtab = tab;
	 }
	
}

function do_blcclick(tab) {
	 tab.style.backgroundColor = setColor(255, 255, 255);
	 curtab=null;
}

function setColor(x,y,z){
		return "#"  + x.toString(16) + y.toString(16) + z.toString(16);
		}
function changeTrColortwo(obj) {
	  var _table=obj.parentNode;

    for (var i=0;i<_table.rows.length;i++){

        _table.rows[i].style.backgroundColor=setColor(232,251,250);

    }    
	var x=69;
    var y=205;
    var z=195;
    obj.style.backgroundColor=setColor(232,251,250);
  if(curtab != null) curtab.style.backgroundColor = setColor(x, y, z);
}

 

 Date.prototype.format = function (format) {
            var args = {
                "M+": this.getMonth() + 1,
                "d+": this.getDate(),
                "h+": this.getHours(),
                "m+": this.getMinutes(),
                "s+": this.getSeconds(),
                "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
                "S": this.getMilliseconds()
            };
            if (/(y+)/.test(format))
                format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var i in args) {
                var n = args[i];
                if (new RegExp("(" + i + ")").test(format))
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
            }
            return format;
        };

