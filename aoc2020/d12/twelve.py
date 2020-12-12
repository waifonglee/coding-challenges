# 90 deg clockwise: x, y := y, -x
# 90 degrees counter clock wise: x, y := - y, x

directions = []
with open('twelve.txt') as f:
    directions = [line.strip() for line in f.readlines()]
    #print(directions)

def clockwiseRotate(coordinates, deg):
    if deg % 360 == 90:
        return [coordinates[1], -coordinates[0]]
    if deg % 360 == 180:
        return [-coordinates[0], -coordinates[1]]        
    if deg % 360 == 270:
        return [-coordinates[1], coordinates[0]] 
    return coordinates


def antiClockwiseRotate(coordinates, deg):
    return clockwiseRotate(coordinates, 360 - deg)

def p1(directions):
    facing = [1, 0]
    posX = 0
    posY = 0

    for d in directions:
        com = d[:1]
        units = int(d[1:])
        print(str(com))
        if com == 'N':
            posY += units
        elif com == 'E':
            posX += units
        elif com == 'S':
            posY -= units
        elif com == 'W':
            posX -= units
        elif com == 'L':
            facing = antiClockwiseRotate(facing, units)
        elif com == 'R':
            facing = clockwiseRotate(facing, units)
        else:
            posX += facing[0] * units
            posY += facing[1] * units
    
    return abs(posX) + abs(posY)

#print(str(p1(directions)))

def p2(directions):
    wp_coord = [10, 1]
    ship_coord = [0, 0]

    for d in directions:
        com = d[:1]
        units = int(d[1:])
        if com == 'N':
            wp_coord[1] += units
        elif com == 'E':
            wp_coord[0] += units
        elif com == 'S':
            wp_coord[1] -= units
        elif com == 'W':
            wp_coord[0] -= units
        elif com == 'L':
            wp_coord = antiClockwiseRotate(wp_coord, units)
        elif com == 'R':
            wp_coord = clockwiseRotate(wp_coord, units)
        else:
            ship_coord[0] += units * wp_coord[0]
            ship_coord[1] += units * wp_coord[1]
        #print(d)
        #print(wp_coord) 
        #print(str(ship_coord))
    return abs(ship_coord[0]) + abs(ship_coord[1])

print(str(p2(directions)))