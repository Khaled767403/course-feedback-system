// src/pages/CreateFormPage.jsx
import { useState } from 'react';
import Navbar from '../components/Layout/Navbar';

function CreateFormPage() {
  const [formTitle, setFormTitle] = useState('');
  const [active, setActive] = useState(true);
  const [questions, setQuestions] = useState(['']);

  const handleAddQuestion = () => {
    setQuestions([...questions, '']);
  };

  const handleRemoveQuestion = (index) => {
    setQuestions(questions.filter((_, i) => i !== index));
  };

  const handleQuestionChange = (index, value) => {
    const newQuestions = [...questions];
    newQuestions[index] = value;
    setQuestions(newQuestions);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const payload = {
      title: formTitle,
      active,
      questions,
    };
    console.log('Submitting form:', payload);
    // Send to backend via axios
  };

  return (
    <div>
      <Navbar role="ADMIN" />
      <div className="p-6 max-w-3xl mx-auto">
        <h2 className="text-2xl font-bold mb-4">Create New Feedback Form</h2>
        <form onSubmit={handleSubmit} className="bg-white p-6 rounded shadow">
          <div className="mb-4">
            <label className="block font-semibold mb-1">Form Title</label>
            <input
              type="text"
              value={formTitle}
              onChange={(e) => setFormTitle(e.target.value)}
              className="w-full border px-3 py-2 rounded"
              required
            />
          </div>

          <div className="mb-4">
            <label className="block font-semibold mb-1">Active</label>
            <input
              type="checkbox"
              checked={active}
              onChange={(e) => setActive(e.target.checked)}
            />{' '}
            Enable Form
          </div>

          <div className="mb-4">
            <label className="block font-semibold mb-2">Questions</label>
            {questions.map((q, idx) => (
              <div key={idx} className="flex items-center mb-2">
                <input
                  type="text"
                  value={q}
                  onChange={(e) => handleQuestionChange(idx, e.target.value)}
                  className="flex-1 border px-3 py-2 rounded"
                  placeholder={`Question ${idx + 1}`}
                  required
                />
                <button
                  type="button"
                  onClick={() => handleRemoveQuestion(idx)}
                  className="ml-2 text-red-500"
                >
                  Remove
                </button>
              </div>
            ))}
            <button
              type="button"
              onClick={handleAddQuestion}
              className="mt-2 text-blue-500"
            >
              + Add Question
            </button>
          </div>

          <button type="submit" className="bg-green-600 text-white px-4 py-2 rounded">
            Save Form
          </button>
        </form>
      </div>
    </div>
  );
}
export default CreateFormPage;
