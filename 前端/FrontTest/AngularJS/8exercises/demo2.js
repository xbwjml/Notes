angular.module('todoApp',[])
       .controller('myCtrl',function($scope){
           
            $scope.todos = [
                {name:'学习', isChecked:false},
                {name:'工作', isChecked:false},
                {name:'休息', isChecked:false}
            ];

            //添加
            $scope.add = function(){
                if( !$scope.newTodo ){
                    alert('输入的内容不能为空');
                    return;
                }
                let obj = {
                    name : $scope.newTodo,
                    isChecked : false
                };
                $scope.todos.unshift(obj);
                $scope.newTodo = '';
            }

            //删除
            // $scope.del = function(){
            //     $scope.todos.forEach((e,index) => {
            //         if(e.isChecked){
            //             $scope.todos.splice(index,1);
            //             $scope.del();
            //         }
            //     });
            // }

            $scope.del = function(){
                var oldTodos = $scope.todos;
                $scope.todos = [];
                oldTodos.forEach((e,index) => {
                    if(!e.isChecked){
                        $scope.todos.push(e);
                    }
                });
            }

       })