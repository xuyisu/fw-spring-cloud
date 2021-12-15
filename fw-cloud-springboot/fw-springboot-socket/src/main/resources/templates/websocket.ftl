<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>websocket通讯</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script>
    var socket;
    function openSocket() {
        if (typeof (WebSocket) == "undefined") {
            console.log("您的浏览器不支持WebSocket");
        } else {
            console.log("您的浏览器支持WebSocket");
            var socketUrl = "http://localhost:9999/pushServer/" + $("#userId").val();
            socketUrl = socketUrl.replace("https", "ws").replace("http", "ws");
            console.log(socketUrl);
            if (socket != null) {
                socket.close();
                socket = null;
            }
            socket = new WebSocket(socketUrl);
            //打开事件
            socket.onopen = function () {
                console.log("websocket已打开");
                //socket.send("这是来自客户端的消息" + location.href + new Date());
            };
            //获得消息事件
            socket.onmessage = function (msg) {
                console.log(msg.data);
                //发现消息进入    开始处理前端触发逻辑
            };
            //关闭事件
            socket.onclose = function () {
                console.log("websocket已关闭");
            };
            //发生了错误事件
            socket.onerror = function () {
                console.log("websocket发生了错误");
            }
        }
    }

    function sendMessage() {
        if (typeof (WebSocket) == "undefined") {
            console.log("您的浏览器不支持WebSocket");
        } else {
            console.log("您的浏览器支持WebSocket");
            console.log('{"toUserId":"' + $("#toUserId").val() + '","contentText":"' + $("#contentText").val() + '"}');
            socket.send('{"toUserId":"' + $("#toUserId").val() + '","contentText":"' + $("#contentText").val() + '"}');
        }
    }
</script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    Hello, WebSocket!
                </h1>
                <p>
                    这是WebSocket测试，浏览器访问地址:http://localhost:9999/page,可以开多个窗口，相互发消息，首先点击"连接Socket"
                </p>
                <p>
                    <a class="btn btn-primary btn-large" onclick="openSocket()" href="#">连接Socket</a>
                </p>
            </div>
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户id</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="userId" value="147258"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">接收人id</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="toUserId" value="123456"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">发送内容</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="contentText" value="测试内容,你好"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" onclick="sendMessage()" class="btn btn-default">发送消息</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>

</html>
