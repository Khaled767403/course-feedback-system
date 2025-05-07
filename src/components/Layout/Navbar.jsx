// src/components/Layout/Navbar.jsx
import { Link } from 'react-router-dom';

function Navbar({ role }) {
  return (
    <nav className="bg-gray-800 text-white p-4 flex justify-between">
      <span className="font-bold">Course Feedback</span>
      <div>
        {role === 'STUDENT' && <Link to="/student" className="px-2">Dashboard</Link>}
        {role === 'INSTRUCTOR' && <Link to="/instructor" className="px-2">Dashboard</Link>}
        {role === 'ADMIN' && <Link to="/admin" className="px-2">Dashboard</Link>}
        <button
          className="ml-4 bg-red-500 px-2 py-1 rounded"
          onClick={() => {
            localStorage.clear();
            window.location.href = '/';
          }}
        >Logout</button>
      </div>
    </nav>
  );
}
export default Navbar;
