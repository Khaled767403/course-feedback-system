// src/pages/StudentDashboard.jsx
import Navbar from '../components/Layout/Navbar';

function StudentDashboard() {
  return (
    <div>
      <Navbar role="STUDENT" />
      <div className="p-6">
        <h2 className="text-2xl font-bold mb-4">Available Feedback Forms</h2>
        <div className="bg-white rounded shadow p-4">
          <p>Here are the forms you can fill anonymously:</p>
          <ul className="list-disc pl-6 mt-2">
            <li>Course Evaluation - OOP</li>
            <li>Instructor Review - Dr. Ahmed</li>
            <li>Course Evaluation - Algorithms</li>
          </ul>
        </div>
      </div>
    </div>
  );
}
export default StudentDashboard;

