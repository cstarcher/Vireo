vireo.controller("OrganizationManagementController", function ($controller, $scope, $q, OrganizationRepo, OrganizationCategoryRepo) {
	angular.extend(this, $controller('AbstractController', {$scope: $scope}));

	$scope.organizationCategories = OrganizationCategoryRepo.get();
	$scope.ready = $q.all([OrganizationRepo.ready(),OrganizationCategoryRepo.ready()]);

	$scope.managedOrganization = null;

	$scope.activeManagementPane = 'edit';

	$scope.ready.then(function() {

		$scope.updateOrganization = function(organization) {
			OrganizationRepo.update(organization).then(function() {
				//update the parent scoped selected organization
				$scope.setSelectedOrganization(organization);
			});
        }

		$scope.getManagedOrganization = function() {
			var currentOrganization = $scope.getSelectedOrganization();
			if (typeof currentOrganization != undefined) {
				if (!$scope.managedOrganization || $scope.managedOrganization.id != currentOrganization.id) {
					$scope.managedOrganization = angular.copy(currentOrganization);
				}
			}
			return $scope.managedOrganization;
		}

		$scope.resetManagedOrganization = function() {
			$scope.managedOrganization = angular.copy($scope.getSelectedOrganization());
		}

		$scope.activateManagementPane = function(pane) {
			$scope.activeManagementPane = pane;
		}

		$scope.managementPaneIsActive = function(pane) {
			return ($scope.activeManagementPane === pane);
		}

	});
});
