var app = angular.module('app', ['ngRoute','ngResource']);

app.config(function($routeProvider){
    $routeProvider
    // $stateProvider
        .when('/questions',{
            templateUrl: '/views/questions.html',
            controller: 'questionsController',
            controllerAs: 'bk',role: 'user'
        })
        .when('/questions/new',{
            templateUrl: '/views/questionCreate.html',
            controller: 'createQuestion',
            controllerAs: 'bk'
        })
        .when('/questionDetail/:id',{
            templateUrl: '/views/detail.html',
            controller: 'questionDetail',
            controllerAs: 'bk'
        })

        .otherwise(
            { redirectTo: '/'}
        );
});

app.factory('denemeService', function($resource) {
    return $resource('http://localhost:8080/questions/:id',{question: '@question'},
        {
            update: {
                method: 'PUT'
            }
        });
});

app.factory('questionService',function ($resource) {
    return $resource('http://localhost:8080/questions/:id',{question: '@question'});
});
