import sys, pygame
pygame.init()


size = width, height = 640, 480
tiespeed = [5, 0]
tie2speed = [7, 0]
tieadvancedspeed = [10, 0]
black = 0,0,0

screen = pygame.display.set_mode(size)
lightsaber = pygame.image.load("lightsaber.jpg")
pygame.display.set_icon(lightsaber)
pygame.display.set_caption('Star Wars')
pygame.mouse.set_visible(0)
pygame.key.set_repeat(10, 10)

background = pygame.Surface(screen.get_size())
background = background.convert()

falcon = pygame.image.load("falcon.png")
falconrect = falcon.get_rect()
tie = pygame.image.load("tie.png")
tierect = tie.get_rect()
tie2 = pygame.image.load("tie.png")
tie2rect = tie2.get_rect()
tieadvanced = pygame.image.load("tieadvanced.png")
tieadvancedrect = tieadvanced.get_rect()

tierect.bottom = 120
tierect.right = 100

tieadvancedrect.bottom = 240
tieadvancedrect.right = 100

tie2rect.bottom = 360
tie2rect.right = 100


x = 50
y = 50
clock = pygame.time.Clock()
hits = 0
collide1 = False
collide2 = False
collide3 = False
done = False

while not done:
    clock.tick(60)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            done = True
        keys_pressed = pygame.key.get_pressed()
        if keys_pressed[pygame.K_DOWN]:
            if y < height - 5:
                y += 5
        if keys_pressed[pygame.K_UP]:
            if y > 37:
                y -= 5
        if keys_pressed[pygame.K_LEFT]:
            if x > 37:
                x -= 5
        if keys_pressed[pygame.K_RIGHT]:
            if x < width - 5:
                x += 5

    if not tierect.colliderect(falconrect):
        collide1 = False
        tierect = tierect.move(tiespeed)
        if tierect.left < 0 or tierect.right > width:
            tiespeed[0] = -tiespeed[0]
    else:
        if not collide1:
            collide1 = True
            hits += 1

    if not tie2rect.colliderect(falconrect):
        collide2 = False
        tie2rect = tie2rect.move(tie2speed)
        if tie2rect.left < 0 or tie2rect.right > width:
            tie2speed[0] = -tie2speed[0]
    else:
        if not collide2:
            collide2 = True
            hits += 1

    if not tieadvancedrect.colliderect(falconrect):
        collide3 = False
        tieadvancedrect = tieadvancedrect.move(tieadvancedspeed)
        if tieadvancedrect.left < 0 or tieadvancedrect.right > width:
            tieadvancedspeed[0] = -tieadvancedspeed[0]
    else:
        if not collide3:
            collide3 = True
            hits += 1

    myfont = pygame.font.SysFont("monospace", 30)

    

    falconrect.bottom = y
    falconrect.right = x

    screen.fill(black)
    labelcaption = "Hits: " + `hits`
    label = myfont.render(labelcaption, True, (250, 250, 250), (0, 0, 0))
    labelrect = label.get_rect()
    labelrect.right = 200
    screen.blit(label, labelrect)
    screen.blit(falcon, falconrect)
    screen.blit(tie, tierect)
    screen.blit(tie2, tie2rect)
    screen.blit(tieadvanced, tieadvancedrect)
    pygame.display.flip()


pygame.quit()
