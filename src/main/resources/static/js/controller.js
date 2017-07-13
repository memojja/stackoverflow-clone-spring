app.controller('questionsController', function($scope,$http,questionService) {

    var vm = this;
    vm.headingTitle = "Question List";
    vm.questions = {};

    vm.name="asdsa";

    vm.questions=questionService.query();

   vm.getDataForUser=function (questionId) {
       vm.questionDetail = questionService.get({id: questionId});
       vm.as="get data for users"
   }

    //calismiyor
   vm.deleteUser = function (questionId) {
       questionService.delete({ id: questionId.id })
   }
    vm.detailQuestion =function (id) {
        window.location = '#/questionDetail/' + id;
    }



});

app.controller('questionDetail',function ($routeParams,questionService ) {

   var vm =this;

        questionService.get({id: $routeParams.id},function (data) {
            vm.questionDetail=data;
        });


})



app.controller('denemeController',function (denemeService,$http,$scope) {

    var vm = this;
    vm.question = {};

    var url = '/questions';
    vm.addUser = function () {
        questionService.save({},question)
    };

    $http.post(url , data).then(function(response) {
        console.log(response.data)
        vm.question = response.data;
    });



    /*
     vm.addQuestion = function() {
     denemeService.save({},vm.question);
     vm.question = {};
     };
     */

});


app.controller("createQuestion", function ($scope, $http) {

    $scope.SendData = function () {
        // use $.param jQuery function to serialize data from JSON
        var data = JSON.stringify({
            "description": $scope.description,
            "categories": $scope.categories,
            "title": $scope.title
    });




        var config = {
            headers : {
                'Content-Type': 'application/json;',
                'Accept': 'application/json',
                method: 'POST',
                data: data

            }
        };

        $http.post('http://localhost:8080/questions', data, config)
            .success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $scope.description="";
                $scope.categories="";
                $scope.title="";
                window.location = "#/questions";


            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data + " ---------------------" +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
    };


});






app.controller("commentController", function ($scope, $http) {
    $scope.deneme="deneme";

    $scope.SendComment = function () {
        // use $.param jQuery function to serialize data from JSON
        var data = JSON.stringify({
            "description": $scope.description,
        });




        var config = {
            headers : {
                'Content-Type': 'application/json;',
                'Accept': 'application/json',
                method: 'POST',
                data: data

            }
        };

        $http.post('http://localhost:8080/comments', data, config)
            .success(function (data, status, headers, config) {
                window.location = "#/questions";


            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data + " ---------------------" +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
    };


});
