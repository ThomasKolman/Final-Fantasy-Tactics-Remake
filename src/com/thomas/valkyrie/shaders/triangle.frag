#version 400 core

out vec4 out_Color;

in vec2 pass_textureCoordinates;

uniform sampler2D textureSampler;
uniform vec4 vColor;

void main()
{
    out_Color = texture(textureSampler, pass_textureCoordinates);
    //out_Color = vColor;
}