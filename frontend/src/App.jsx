import {useState} from 'react';
function App(){
    // {"id":1,"name":"Akash","course":"Computer Science"}
    const [students, setStudents] = useState([])
    const [count, setCount] = useState(0)
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const getStudentData = async()=>{
        const response = await fetch('http://localhost:8080/student');
        const data = await response.json();
        setStudents(data)
    }
    const fetchTotalStudentCount = async()=>{
        const response = await fetch('http://localhost:8080/student/count');
        const count = await response.json();
        setCount(count);
    }
    const login = async()=>{
        const response = await fetch('http://localhost:8080/auth/login',{
            method:'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body: JSON.stringify({username,password}),
        });
        alert('Login successful');
    }
    return(
        //<div>
           
        //     <center><button onClick={getStudentData}>Get Student Data</button></center>
        //     <center><button onClick={fetchTotalStudentCount}>Get Student Count</button></center>
        //     <p>Total students: {count}</p>
        //     <ul>
        //         {students.map((student) => (
        //             <li key={student.id}>
        //                 <h2>{student.name}</h2>
        //                 <h2>{student.course}</h2>
        //             </li>
        //         ))}
        //     </ul>
        // </div>

    <div>
        <h1 align='center'>Welcome to the App!</h1>
        <h3 align='center'>This the student Data</h3>

        <input placeholder="Username" onChange={(e)=>setUsername(e.target.value)} />

        <input placeholder="Password" onChange={(e)=> setPassword(e.target.value)}/>

        <button onClick={login}> Login </button>

    </div>
        
    );
}
export default App;