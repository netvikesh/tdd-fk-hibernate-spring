import React from "react";
import {render} from "react-dom";
import GreeterFormComponent from "./GreeterFormComponent.jsx";

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            message: props.message,
            firstName: props.firstName,
            notifications: props.notifications
        };
        this.handleNewName = this.handleNewName.bind(this);
    }

    render() {
        return (
            <div>
                <h1>{this.state.message} {this.state.firstName}</h1>
                <p>{this.state.notifications}</p>
                <GreeterFormComponent />
            </div>
        );
    }
}

render(
    <App />,
    document.getElementById('app')
);

App.props = {
    message: 'Hello, From Parent Component',
    firstName: 'Vikesh',
    notifications: ['Notification 1', 'Notification 2', 'Notification 3']
}