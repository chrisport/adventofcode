package main

import (
	"fmt"
	"io/ioutil"
	"strings"
)

func main() {
	f, err := ioutil.ReadFile("input")
	panicOnErr(err)
	lines := strings.Split(string(f), "\n")
	mp := make(map[string]int)

	for _, v := range lines {
		if occurrences[v]
		mp[v] = 0
	}

}

func hasA(lines []string, minAppearence int) {
	sum := 0

	fmt.Println("Solution task 1:", sum)
}

func panicOnErr(err error) {
	if err != nil {
		panic(err)
	}
}
