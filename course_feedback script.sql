CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255),
  role ENUM('STUDENT', 'INSTRUCTOR', 'ADMIN') NOT NULL
);

CREATE TABLE courses (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(100) NOT NULL UNIQUE,
  instructor_id BIGINT NOT NULL,
  FOREIGN KEY (instructor_id) REFERENCES users(id)
);

CREATE TABLE feedbackforms (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  course_id BIGINT NOT NULL,
  created_by BIGINT NOT NULL,
  active BOOLEAN NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (course_id) REFERENCES courses(id),
  FOREIGN KEY (created_by) REFERENCES users(id)
);

CREATE TABLE questions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  form_id BIGINT NOT NULL,
  text VARCHAR(1000) NOT NULL,
  type ENUM('TEXT', 'RATING') NOT NULL,
  FOREIGN KEY (form_id) REFERENCES feedbackforms(id)
);

CREATE TABLE feedbacksubmissions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  form_id BIGINT NOT NULL,
  student_id BIGINT NOT NULL,
  submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (form_id) REFERENCES feedbackforms(id),
  FOREIGN KEY (student_id) REFERENCES users(id)
);

CREATE TABLE answers (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  submission_id BIGINT NOT NULL,
  question_id BIGINT NOT NULL,
  answer_text TEXT,
  rating INT CHECK (rating BETWEEN 1 AND 5),
  FOREIGN KEY (submission_id) REFERENCES feedbacksubmissions(id),
  FOREIGN KEY (question_id) REFERENCES questions(id)
);
