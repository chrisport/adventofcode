package main

import (
	"fmt"
	"io/ioutil"
	"strconv"
	"strings"
)

func main() {
	f, err := ioutil.ReadFile("input")
	panicOnErr(err)
	lines := strings.Split(string(f), "\n")
	task1(lines)
	task2(lines)
	task2recursion(lines, 0, make(map[int]int))
}

func task1(lines []string) {
	sum := 0
	for v := range lines {
		b, err := strconv.Atoi(lines[v])
		panicOnErr(err)
		sum += b
	}
	fmt.Println("Solution task 1:", sum)
}

func task2(lines []string) {
	sum := 0
	cache := make(map[int]int)
	for {
		for v := range lines {
			b, err := strconv.Atoi(lines[v])
			panicOnErr(err)
			sum += b
			cache[sum] = cache[sum] + 1
			if cache[sum] > 1 {
				fmt.Println("Solution task 2:", sum)
				return
			}
		}
	}
	task2recursion(lines, sum, cache)
}

func task2recursion(lines []string, sum int, cache map[int]int) {
	for v := range lines {
		b, err := strconv.Atoi(lines[v])
		panicOnErr(err)
		sum += b
		cache[sum] = cache[sum] + 1
		if cache[sum] > 1 {
			fmt.Println("Solution task 2:", sum)
			return
		}
	}
	task2recursion(lines, sum, cache)
}

func panicOnErr(err error) {
	if err != nil {
		panic(err)
	}
}
