import React from "react";
import List from "./components/List";
import dummyItems from "./items.json";

export default class App extends React.Component {
  state = {
    favItems: []
  };

    render() {
    const { favItems } = this.state;
    return (
      <div className="container-fluid">
        <h1 className="text-center">
          Welcome!
          <small>Class-based</small>
        </h1>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
               title="Our Menu"
               items={dummyItems}
               onItemClick={(item) => this.handleItemClick(item, false)}
               hideCheckbox={true}
               />
            </div>
            <div className="col-sm">

              <List 
              title= "My Favorite"
              items={favItems}
              onItemClick={(item) => this.handleItemClick(item, true)}
              hideCheckbox={false}
              />
            </div>
          </div>
        </div>
      </div>
    );
  }

  handleItemClick = (item, isDelete) => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else if (isDelete) newItems.splice(targetInd, 1);
    this.setState({ favItems: newItems });
  };

  
}
