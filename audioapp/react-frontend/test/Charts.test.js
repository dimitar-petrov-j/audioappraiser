import React from "react"
import { cleanup, render, screen } from "@testing-library/react"
import ShallowRenderer from "react-test-renderer/shallow"
import Charts from "../src/Pages/Charts"


afterEach(cleanup);

test("renders correctly react-test-renderer", () => {
    const renderer = new ShallowRenderer()
    renderer.render(<Charts />)
    const result = renderer.getRenderOutput()
    expect(result).toMatchSnapshot()
})