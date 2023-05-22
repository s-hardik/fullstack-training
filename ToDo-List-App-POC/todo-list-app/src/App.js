import logo from './logo.svg';
import './App.css';
import TodoList from './components/TodoList';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Route, Routes } from 'react-router-dom';
import TodoDetailsModals from './components/Modals/TodoDetailsModals';

function App() {
  return (
   <Routes>
    <Route path='/' element={<TodoList/>} />
    <Route path='/updateTask/:id' element={<TodoList/>} />
   </Routes>
  );
}

export default App;
