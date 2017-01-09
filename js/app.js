var app=angular.module("sideWallApp",[]);

app.controller("sideWallCtrl",function($scope){
	$scope.jobs=[
		{
			title:"Seeking SECURITY MGR with 2 years of experience in security",
			address:"123 Weigh Way",
			numRoutes:"12",
			description:"American Protection Group (APG) a rate A+ Business Member of the Better Business Bureau (BBB) is seeking a manager with a CLASS MB License OR individual that can qualify for a Class MB license for both A and B licenses that we already have. American Protection Group is expanding to the Florida market and is currently licensed in CA, NV, AZ and FL, now in the process of expanding to TX and NM. We are seeking a qualified applicant with a CLASS MB license or someone whom can take the exam and become our manager for the FL market."
		},
		{
			title:"Veterinary Technician/Assistant",
			address:"456 Play Place",
			numRoutes:"7",
			description:""
		},
		{
			title:"Restaurant Crew Member, Shift Leader",
			address:"123 Weigh Way",
			numRoutes:"12",
			description:""
		}
	];
});