angular.module('myApp', [])
       .controller('myCtrl',['$scope',function($scope){

            //初始化msg
            $scope.msg = '';
            //计算剩余字数
            $scope.getRemain = function(){
                if( $scope.msg.length > 10 ){
                    $scope.msg = $scope.msg.slice(0,10);
                }
                return 10 - $scope.msg.length ;
            }

            //保存msg
            $scope.save = function(){
                localStorage.setItem('msg', JSON.stringify($scope.msg));
                $scope.msg = '';
            }

            //读取msg
            $scope.read = function(){
                $scope.msg = JSON.parse(localStorage.getItem('msg') || '[]');
            }

            //删除msg
            $scope.delete = function(){
                localStorage.removeItem('msg');
                $scope.msg = '';
            }

       }])