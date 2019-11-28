"use strict";

const app = angular.module('recipeApp', ['ui.bootstrap']);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.controller('recipeController', function($http,$window, $location, $uibModal, $scope) {
    const demoApp = this;
    $scope.recipies = null;
    $scope.selectedRecipeInfo = null;
    $scope.addButtonShow=false;
    $scope.updateButtonShow=false;
    $scope.deleteButtonShow=false;
    $scope.searchBar=false;
    $scope.searchButton=false;
    $scope.showImageUrl=false;
    $scope.searchEnablerShow=true;
   // const apiBaseURL = "http://localhost:8080/";
    
    $scope.init = function () {
        $http.get('recipies').then(function (response){
        	if(response){
        		console.info('response :: '+response.data[0]);
        		$scope.recipies = response.data;
        	}
        },function (error) {
            $scope.responseMsg = "Service not Exists";
        });
    }
    
    $scope.getRecipeDetails = function () {
    	$http({
    	    method : "GET",
    	      url : 'recipieById/'+$scope.selectedRecipe
    	  }).then(function mySuccess(response) {
    		  console.info('get by id response :: '+response.data);
    		  $scope.selectedRecipeInfo = response.data;
    	  }, function myError(response) {
    		  console.info('Error from  ::getRecipeDetails '+response.data);
    	    
    	  });
    }
    
    $scope.addNewRecipe = function () {
    	console.info('addNewRecipe :: value '+$scope.selectedRecipeInfo.recipeName);
    	$http(
				{
					method : 'POST',
					url : 'addRecipe/',
					data : $scope.selectedRecipeInfo,
					transformResponse : [ function(
							data) {
						var transresp = JSON
								.parse(data);
						return transresp;
					} ]
				}).then(function mySuccess(response) {
					console.info('addNewRecipe :: response '+response.data);
				    alert("New Recipe Addedd !!");
				    $scope.showImageUrl=false;
				    $scope.init();
				    
		    	  }, function myError(response) {console.info('Error from  ::addNewRecipe '+response.data);console.info('Error from  ::getRecipeDetails '+response.data);
		    	    
		    	  });
    }
    
    $scope.updateRecipe = function (updatedValue) {
    	console.info('updateRecipe :: id'+updatedValue.likeCount);
    	$http(
				{
					method : 'PUT',
					url : 'updateRecipe/'+$scope.selectedRecipeInfo.recipieId,
					data : updatedValue,
					transformResponse : [ function(
							data) {
						var transresp = JSON
								.parse(data);
						return transresp;
					} ]
				}).then(function mySuccess(response) {
					console.info('updateRecipe :: response '+response.data);
					window.alert("Recipe Updated !!");
					$scope.init();
		    	  }, function myError(response) {console.info('Error from  ::addNewRecipe '+response.data);console.info('Error from  ::getRecipeDetails '+response.data);
		    	  console.info('Error from  ::updateRecipe '+response.data);
		    	  });
    }
    
    $scope.deleteRecipe = function () {
    	console.info('deleteRecipe :: ');
    	$http({
			method : 'DELETE',
			url : 'deleteRecipe/'+$scope.selectedRecipeInfo.recipieId
		}).then(function mySuccess(response) {
			console.info('successfully deleted');
			window.alert("Recipe Deleted !!");
			$scope.init();
			$scope.selectedRecipeInfo = null;
    	  }, function myError(response) {console.info('Error from  ::addNewRecipe '+response.data);console.info('Error from  ::getRecipeDetails '+response.data);
    	  console.info('Error in deleteRecipe :: ');
    	  });
    }
    
    $scope.searchRecipe = function () {
    	console.info('searchRecipe :: search string :: '+$scope.searchString);
    	$http({
    	    method : "GET",
    	      url : 'searchRecipe/'+$scope.searchString
    	  }).then(function mySuccess(response) {
    		  console.info('get by id response :: '+response.data);
    		  if(response.data == null){
    			  window.alert("No recipe found with "+$scope.searchString);
    		  }
    		  $scope.selectedRecipeInfo = response.data;
    		  $scope.searchEnablerShow=true;
    		  $scope.searchBar=false;
    		  $scope.searchButton=false;
    	  }, function myError(response) {
    		  console.info('get by id response :: '+response.data);
    		  $scope.searchEnablerShow=true;
    		  $scope.searchBar=false;
    		  $scope.searchButton=false;
    	    $scope.myWelcome = response.statusText;
    	  });
    }
    
    $scope.enableAddButton = function () {
    	console.info('enableAddButton :: ');
        $scope.addButtonShow=true;
        $scope.updateButtonShow=false;
        $scope.deleteButtonShow=false;
        $scope.selectedRecipeInfo = null;
        $scope.showImageUrl=true;
    }
    $scope.enableUpdateButton = function () {
    	console.info('enableUpdateButton :: ');
        $scope.addButtonShow=false;
        $scope.updateButtonShow=true;
        $scope.deleteButtonShow=false;
        $scope.showImageUrl=false;
    }
    $scope.enableDeleteButton = function () {
    	console.info('enableDeleteButton :: ');
        $scope.addButtonShow=false;
        $scope.updateButtonShow=false;
        $scope.deleteButtonShow=true;
        $scope.showImageUrl=false;
    }
    $scope.enableSearch = function () {
    	console.info('enableSearch() :: ');
        $scope.addButtonShow=false;
        $scope.updateButtonShow=false;
        $scope.deleteButtonShow=false;
        $scope.searchEnablerShow=false;
        $scope.searchBar=true;
        $scope.searchButton=true;
        $scope.showImageUrl=false;
    }    
    
    
});