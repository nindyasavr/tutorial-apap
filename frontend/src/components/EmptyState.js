import React from "react";

export default function EmptyState() {
    const styles = {
        heading: {
            fontFamily: "courier new"
        }
    };
    return (
        <>
        <div className="text-center">
            <h2>Belum ada item yang dipilih</h2>
            <h3>Klik salah satu item di daftar Menu</h3>
        </div>
        </>
    );
}
