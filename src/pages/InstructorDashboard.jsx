

// src/pages/InstructorDashboard.jsx
import Navbar from '../components/Layout/Navbar';

function InstructorDashboard() {
  return (
    <div>
      <Navbar role="INSTRUCTOR" />
      <div className="p-6">
        <h2 className="text-2xl font-bold mb-4">Feedback Summary</h2>
        <div className="bg-white rounded shadow p-4">
          <p>Summary of Ratings:</p>
          <ul className="list-disc pl-6 mt-2">
            <li>Course: OOP - Average Rating: 4.2</li>
            <li>Course: Data Structures - Average Rating: 3.9</li>
            <li>Your Instructor Rating: 4.1</li>
          </ul>
        </div>
      </div>
    </div>
  );
}
export default InstructorDashboard;

