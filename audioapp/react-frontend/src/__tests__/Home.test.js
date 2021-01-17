import React from "react";
import { cleanup, render, screen } from "@testing-library/react"
import ShallowRenderer from "react-test-renderer/shallow";
import Home from "../Pages/Home";


afterEach(cleanup);

it("renders correctly react-test-renderer", () => {
    const renderer = new ShallowRenderer();
    renderer.render(<Home />);
    const result = renderer.getRenderOutput();
    expect(result).toMatchSnapshot();
});