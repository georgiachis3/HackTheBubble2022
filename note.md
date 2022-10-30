 JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("/img/menu.png")));
        contentPane.add(background);
        background.setLayout(null);
        l1 = new JLabel("here is the button");
        background.add(l1);
        l1.setForeground(Color.YELLOW);
        
        ImageIcon imageone = new ImageIcon(this.getClass().getResource("/img/SpaceHorse.png"));
        b1 = new JButton("", imageone);
        Dimension size = b1.getPreferredSize();
        b1.setBounds(1000,500, size.width, size.height);

        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        background.add(b1);
