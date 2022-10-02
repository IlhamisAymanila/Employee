import './App.css';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import AddEmployeeComponent from './components/AddEmployeeComponent';
import Login from './components/Login';

function App() {
  return (
    <div>
      <Router>
        <div className= "container">
          <Switch>
              <Route exact path = "/" component = {ListEmployeeComponent}></Route>
              <Route path = "/employees" component = {ListEmployeeComponent}></Route>
              <Route path = "/add-employee" component = {AddEmployeeComponent} ></Route>
              <Route path = "/edit-employee/:id" component = {AddEmployeeComponent}></Route>
              <Route path = "/login" component = {Login}></Route>
            </Switch>
        </div>
        </Router>
    </div>
  );
}

export default App;
