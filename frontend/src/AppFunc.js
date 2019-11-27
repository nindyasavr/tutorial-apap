import React, { useState } from "react";
import List from "./components/List";

import dummyItems from "./items.json";
import EmptyState from "./components/EmptyState";
/**
* Building React component using functional programming paradigm
*/
function App() {
    // Btw, this is hooks. useState function returns an array
    // contains the state and a function to set the state -> [state, setState].
    // What you see below is array destruction.
    // Let say you have an array const arr = ["aaa", "bbb"], to access the item
    // we can use index arr[0] OR destruct it like below
    // const [varName, index1] = arr, variable varName is guaranteed to get the value of index 0 OR "aaa"
    // here is the illustration for this situation
    // below is the return value of useState
    // [favItems, setFavItems] = [state, setState]
    const [favItems, setFavItems] = useState(() => []);
    const [checked, setChecked] = useState(() => false);

   function handleChange() {
       setChecked(!checked);
   }

    function handleItemClick(item, isDelete) {
        // immutability
        const newItems = [...favItems];
        const newItem = { ...item };
        // find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        if (targetInd < 0) newItems.push(newItem);
        else if (isDelete) newItems.splice(targetInd, 1); // delete 1 item at index targetInd
        // schedule to set a new state
        setFavItems(newItems);
    }

    function displayFav(checked) {
        if (checked === true && favItems.length > 0) {
            return(
                <div className col-sm>
                    <List
                        title="My Favorite"
                        items={favItems}
                        onItemClick={(item) => handleItemClick(item, true)}
                        hideCheckbox={false}
                        inputType="checkbox"
                    />
                </div>
            );
        }
        else if (checked === true && favItems.length == 0) {
            return (
                <div className col-sm>
                    <h3>My Favorite</h3>
                    <EmptyState/>
                </div>
            );
        }
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center">
                Welcome!
            <small>Functional</small>
            </h1>
            <div className="container pt-3">
                <div>
                    <input type="checkbox" onChange={handleChange}/>
                    <small>Show Favorite</small>
                </div>
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="Our Menu"
                            items={dummyItems}
                            onItemClick={(item) => handleItemClick(item, false)}
                            hideCheckbox={true}
                        />   
                    </div>
                    <div className="col-sm">
                        {displayFav(checked)}
                    </div>
                </div>
            </div>
        </div>
    );
}
export default App;
