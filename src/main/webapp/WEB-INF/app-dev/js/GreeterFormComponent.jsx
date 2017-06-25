import React from "react";

export  default class GreeterFormComponent extends React.Component {
    constructor(props) {
        super(props);
    }

    _onValueChange(e) {
        console.log(this.refs.secondInput.value);
    }


    render() {
        return (
            <form>
                <input type="input" ref="secondInput" onChange={this._onValueChange.bind(this)}/>
                <button type="button">Second Clear</button>
            </form>
        );
    }
}
