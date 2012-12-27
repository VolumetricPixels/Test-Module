#version 330

in vec4 color;
in vec4 normal;
in vec2 uvcoord;

uniform sampler2D Diffuse;

layout(location=0) out vec4 outputColor;

void main() {
	vec4 fontsample = texture(Diffuse, uvcoord);
	outputColor = fontsample * color;
}
