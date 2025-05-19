<?php
// Database connection
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "s_system";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Get POST data from the Android app
$subject_name = $_POST['subject_name'];
$subject_code = $_POST['subject_code'];
$teacher_id = $_POST['teacher_id'];

// SQL query to insert new subject
$sql = "INSERT INTO subjects (subject_name, subject_code, teacher_id) 
        VALUES ('$subject_name', '$subject_code', '$teacher_id')";

if ($conn->query($sql) === TRUE) {
    echo "New subject added successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
