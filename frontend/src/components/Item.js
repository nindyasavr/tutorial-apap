import React from "react";

export default function Item(props) {
    const { item, onChange} = props
    const { nama, deskripsi, harga, checked } = item;

    const handleChange = () =>
        !!onChange && onChange({...item, checked: !checked});

    return (
        <button type="button"
        className="lis"
    )

}