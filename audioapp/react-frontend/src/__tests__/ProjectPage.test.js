import React from "react"
import { cleanup, render, screen } from "@testing-library/react"
import ShallowRenderer from "react-test-renderer/shallow"
import ProjectPage from "../Pages/ProjectPage"


afterEach(cleanup);

it("renders correctly react-test-renderer", () => {
    const renderer = new ShallowRenderer()
    render(<ProjectPage />)
    const result = renderer.getRenderOutput()
    expect(result).toMatchSnapshot()
})