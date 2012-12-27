#version 120

attribute vec4 vPosition;
attribute float vlight;
attribute vec4 vNormal;
attribute vec2 vTexCoord;
attribute float vskylight;
attribute vec4 vBiomeColor;

varying vec4 normal;
varying vec4 color;
varying vec4 biomecolor;
varying vec2 uvcoord;

uniform mat4 Projection;
uniform mat4 View;
uniform mat4 Model;
uniform vec4 sunColor;
uniform vec4 moonColor;
uniform vec4 skyColor;
uniform vec4 sunDir;
uniform float ambient;

void main() {
	gl_Position = Projection * View  * Model * vPosition;

	normal = vNormal;

	vec3 L = normalize(sunDir.xyz);
	vec3 E = normalize(-vPosition.xyz); // we are in Eye Coordinates, so EyePos is (0,0,0)
	vec3 R = normalize(-reflect(L,vNormal.xyz));

	//calculate Ambient Term:
	vec4 Iamb = skyColor * ambient * vskylight;

	//calculate Diffuse Term:
	float dotProd = (1 + dot(vNormal.xyz,L)) / 2;
	vec4 Idiff = (1 - ambient) * ((sunColor * max(dotProd, 0.0)) + (moonColor * max(1 - dotProd, 0.0)));
	Idiff = clamp(Idiff * vskylight, 0.0, 1.0);

	// calculate Specular Term:
	// float shininess = 0.1;
	// vec4 Ispec = skyColor * 0.3 * pow(max(dot(R,E),0.0),0.3 * shininess);
	// Ispec = clamp(Ispec * vskylight, 0.0, 1.0);

	color = vec4(vlight, vlight, vlight, 1) + Iamb + Idiff;

	uvcoord = vTexCoord;

	biomecolor = vBiomeColor;
}
