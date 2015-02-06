function ChatServices(){};

ChatServices.connect = function(onSuccess, onFail){
  cordova.exec(onSuccess, onFail, 'ChatServices', 'connect', []);
};

module.exports = ChatServices;
