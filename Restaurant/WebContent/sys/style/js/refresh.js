/**
 * 用于10秒后返回前一页面
 */
var t = 9;// 设定跳转的时间
setInterval("refer()", 1000); // 启动1秒间距

function refer() {
	if (t == 0) {
		javascript: history.back(-1); // 返回前一页面
	}
	document.getElementById('refresh').innerHTML = t;// 显示倒计时
	t--; // 计数器递减
}
