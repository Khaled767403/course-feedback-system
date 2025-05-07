// src/pages/AdminDashboard.jsx
import Navbar from '../components/Layout/Navbar';
import { useNavigate } from 'react-router-dom';

function AdminDashboard() {
  const navigate = useNavigate();
  return (
    <div>
      <Navbar role="ADMIN" />
      <div className="p-6">
        <h2 className="text-2xl font-bold mb-4">Manage Feedback Forms</h2>
        <div className="bg-white rounded shadow p-4">
          <p>Form List:</p>
          <ul className="list-disc pl-6 mt-2">
            <li>
              OOP Course Form - Status: <span className="text-green-600">Active</span>
              <button className="ml-2 text-blue-500">Edit</button>
              <button className="ml-2 text-red-500">Deactivate</button>
            </li>
            <li>
              Instructor Evaluation - Status: <span className="text-red-600">Inactive</span>
              <button className="ml-2 text-blue-500">Edit</button>
              <button className="ml-2 text-green-500">Activate</button>
            </li>
          </ul>
          <button
            className="mt-4 bg-blue-500 text-white px-4 py-2 rounded"
            onClick={() => navigate('/admin/create-form')}
          >
            Create New Form
          </button>
        </div>
      </div>
    </div>
  );
}
export default AdminDashboard;
