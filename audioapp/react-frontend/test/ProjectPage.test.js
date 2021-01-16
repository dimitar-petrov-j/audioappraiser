import React from "react"
import { cleanup, render, screen } from "@testing-library/react"
import ShallowRenderer from "react-test-renderer/shallow"
import ProjectPage from "../src/Pages/ProjectPage"


afterEach(cleanup);

test("renders correctly react-test-renderer", () => {
    const renderer = new ShallowRenderer()
    render(<ProjectPage />)
    const result = renderer.getRenderOutput()
    expect(result).toMatchSnapshot()
})