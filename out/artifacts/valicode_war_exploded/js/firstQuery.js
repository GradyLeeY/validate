var w = 80;
var h = 24;
var fontsize = h-6;
var str = "0123456789abcdefABCDEF";

//随机生成最大值不超过max的数
function randomINt(max) {
    return Math.floor(Math.random()*100000%max);
}

function randCode(len) {
    if (len<4){
        len = 4;
    }
    var code = "";
    for (var i = 0; i < len; i++) {
        code += str.charAt(randomINt(str.length));
    }
    return code;
}

function randomColor() {
    var r = randomINt(256);
    var g = randomINt(256);
    var b = randomINt(256);
    return "rgb("+r+","+g+","+b+")";
}

function drawcode(canvas) {
    var valicode = randCode(4);
    w = 5+fontsize*valicode.length;
    if (canvas != null && canvas.getContext && canvas.getContext("2d")){
        //设置显示区域
        canvas.style.width = w;
        //设置画板的高度宽度
        canvas.setAttribute("width",w);
        canvas.setAttribute("height",h);
        //得到画笔
        var pen = canvas.getContext("2d");
        //绘制背景
        pen.fillStyle = "rgb(255,255,255)";
        pen.fillRect(0,0,w,h);
        //设置水平线
        pen.textBaseline = "top";
        //绘制内容
        for (var i = 0; i < valicode.length; i++) {
            pen.fillStyle = randomColor();
            pen.font = "blod"+(fontsize+randomINt(3))+"px 微软雅黑";
            pen.fillText(valicode.charAt(i),5+fontsize*i,randomINt(5));

        }
        //绘制噪音线
        for (var i = 0; i < 2; i++) {
            pen.moveTo(randomINt(w)/2,randomINt(h));//设置起点
            pen.lineTo(randomINt(w),randomINt(h));
            pen.strokeStyle = randomColor();
            pen.lineWidth = 2;//线条粗细
            pen.stroke();
        }
        return valicode;
    }
}