import GreeterMessageComponent from "./GreeterMessageComponent";
import React from 'react';

class GreeterComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = props;
        console.log("Initial State", JSON.stringify(this.state));
    }

    _onClick(e) {
        var name = this.refs.desiredName;
        name.value = "";
    };

    _onChange(e) {
        var name = this.refs.desiredName;
        this.setState({
            firstName: name.value,
        });
        console.log("Change Trigerred");

    };

    _onSubmit(e) {
        e.preventDefault();
    };

    render() {
        return (
            <div>
                <GreeterMessageComponent/>
                <h1>{this.state.greeting} {this.state.firstName}</h1>
                <p>{this.state.notifications}</p>
                <form onSubmit={this._onSubmit.bind(this)}>
                    <input type="text" ref="desiredName" onChange={this._onChange.bind(this)}/>
                    <button onClick={this._onClick.bind(this)} type="button">Clear</button>
                </form>
            </div>
        );
    }
}

GreeterComponent.defaultProps = {
    greeting: 'Welcome',
    firstName: 'Vikesh',
    notifications: ["Notification 1", "Notification 2", "Notification 3"],
};

ReactDOM.render(
    <GreeterComponent/>,
    document.getElementById('app')
);

