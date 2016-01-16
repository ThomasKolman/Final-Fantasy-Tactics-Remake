#version 400 core

layout(location = 0) in vec3 position;
layout(location = 1) in vec2 textureCoordinates;

out vec2 pass_textureCoordinates;

uniform mat4 gWorld;

void main()
{
    gl_Position = gWorld * vec4(position, 1.0);
    pass_textureCoordinates = textureCoordinates;
}