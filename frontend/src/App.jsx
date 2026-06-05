import {useState} from 'react';
function App(){
    // {"id":1,"name":"Akash","course":"Computer Science"}
    const [students, setStudents] = useState({})
    const getStudentData = async()=>{
        const response = await fetch('http://localhost:8080/student');
        const data = await response.json();
        setStudents(data)
    }
    return(
        <div>
            <h1 align='center'>Welcome to the App!</h1>
            <h3 align='center'>This the student Data</h3>
            <center><button onClick={getStudentData}>Get Student Data</button></center>
            <h2>{students.id}</h2>
            <h2>{students.name}</h2>
            <h2>{students.course}</h2>
        </div>
        
    );
}
export default App;