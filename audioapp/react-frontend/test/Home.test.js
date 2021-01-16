import React from "react";
import { cleanup, render, screen } from "@testing-library/react"
import ShallowRenderer from "react-test-renderer/shallow";
import Home from "../src/Pages/Home";


afterEach(cleanup);

test("renders correctly react-test-renderer", () => {
    const renderer = new ShallowRenderer();
    renderer.render(<Home />);
    const result = renderer.getRenderOutput();
    expect(result).toMatchSnapshot();
});