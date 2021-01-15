'use strict'

function addPoint(_x, _y, _r, _result) {
    const graph = document.getElementById('graph-svg');
    let x = Number(_x);
    let y = Number(_y);
    let r = Number(_r);
    let color;
    if (typeof _result === "boolean") {
        color = _result ? "#FFE500" : "red";
    }
    else color = _result==='true' ? "#FFE500" : "red";
    let dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    dot.setAttribute("r", "3");
    dot.setAttribute("cx", String(200 + x * 140/r));
    dot.setAttribute("cy", String(200 - y * 140/r));
    //dot.setAttribute("class", "dotted-raw-x");
    dot.setAttribute("fill", color);
    graph.appendChild(dot);
}

function redrawPoints() {
    document.getElementById('point-table_data').childNodes.forEach(row => {
        let cells = row.childNodes;
        console.log(cells);
        addPoint(cells[0].innerText, cells[1].innerText, cells[2].innerText, cells[4].innerText);
    });
}
window.onload = redrawPoints;