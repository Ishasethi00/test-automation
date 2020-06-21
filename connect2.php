<?php
	

	$conn = new mysqli('localhost','root','','covid19_ss') or die("unable to connect to host");
	if(!($conn)){
		echo "Unable to connect";
	}	
	$fname = "";
	$lname = "";
	$pid= "";
	$dob = "";
	$add1stre = "";
	$add1cit="";
	$add1sta="";
	$source = "";
	$add2stre = "";
	$add2cit="";
	$add2sta="";
	$dir = "";
	$testm = "";
	$spe = "";
	$dop = "";
	$res = "";
	if(isset($_POST['button1'])){
		$fname = $_POST['fname'];
		$lname = $_POST['lname'];
		$pid= $_POST['pid'];
		$dob = $_POST['dob'];
		$add1stre = $_POST['add1stre'];
		$add1cit = $_POST['add1cit'];
		$add1sta = $_POST['add1sta'];
		$source = $_POST['source'];
		$add2stre = $_POST['add2stre'];
		$add2cit = $_POST['add2cit'];
		$add2sta = $_POST['add2sta'];
		$dir = $_POST['dir'];
		$testm = $_POST['testm'];
		$spe = $_POST['spe'];
		$dop = $_POST['dop'];
		$res = $_POST['res'];
		$sql_id = "select * from registry where Name='$fname'";
		$sql = "insert into registry(Name, Last_Name, P_ID, DOB, Add1_Street, Add1_City, Add1_State, Source, Add2_Street, Add2_City, Add2_State, Lab_Director, Test_Method, Specimen, Performed_Date, Result) values ('$fname','$lname', '$pid', '$dob', '$add1stre', '$add1cit','$add1sta', '$source', '$add2stre','$add2cit','$add2sta','$dir','$testm', '$spe', '$dop', '$res')";
		mysqli_query($conn,$sql);
		echo "Successful";
		exit();

	}
?>