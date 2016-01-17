#version 400 core

layout (location = 0) out vec4 out_Color;

in vec2 pass_textureCoordinates;

uniform sampler2D textureSampler;

void main()
{
    out_Color = texture(textureSampler, pass_textureCoordinates);
}