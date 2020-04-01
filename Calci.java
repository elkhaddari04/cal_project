
public class Calci extends javax.swing.JFrame {

    String enternumber,enternumber1;
    double n1,n2;
    int check=0;
    int p=0,top=-1;
    int p_count=0;
    String postfi;
    char stack[];
    char temp;
    double num1;
    double num2;
    double result;
    char op;
    public Calci() {
        initComponents();
    }

    class Infix
    {
        public void push(char n)
        {
            top++;
            stack[top]=n;
        }
        public  char pop()
        {
            char v;


            v=stack[top];
            top--;

            return v;
        }
        public int getpriority(char op)
        {
            if(op=='/'||op=='*'||op=='%')
                return 1;
            else if(op=='+'||op=='-')
                return 0;

            return 0;

        }
        public String infix_to_postfix(String t,String post)
        {
            char []infix =t.toCharArray();
            char []postfix=post.toCharArray();
            int p,i=0,j=0;
            p=t.length();
            while(infix[i]!='\0')
            {
                if(infix[i]=='(')
                {
                    push(infix[i]);
                    i++;
                }
                else if(infix[i]==')')
                {
                    while(top!=-1&&(stack[top]!='('))
                    {
                        postfix[j++]=pop();
                    }
                    if(top==-1)
                    {
                        display.setText("Incorrect Expression \n");

                    }
                    temp=pop();
                    i++;
                }
                else if((infix[i]=='+')||(infix[i]=='-')||(infix[i]=='*')||(infix[i]=='/')||infix[i]=='%')
                {
                    while(top!=-1&&stack[top]!='('&&getpriority(stack[top])>getpriority(infix[i]))
                    {
                        postfix[j++]=pop();
                    }
                    push(infix[i]);
                    i++;
                }
                else if(Character.isDigit(infix[i])||Character.isLetter(infix[i]))
                {
                    postfix[j++]=infix[i++];
                }
                else
                {
                    display.setText("Incorrect statement !!!\n");

                }



            }
            String a=new String(postfix);
            return a;
        }
        float evaluatepostfixexpression(String po)
        {
            int i=0;
            float ope1,ope2,value=0;
            //.// char postfix[];
            char postfix[]=po.toCharArray();
            while(postfix[i]!='\0')
            {
                if(Character.isDigit(postfix[i]))
                {


                    push((postfix[i]));

                }
                else
                {
                    ope2=pop();
                    ope1=pop();
                    switch(postfix[i])
                    {
                        case '+':value=ope1+ope2;
                            break;
                        case '-':value=ope1-ope2;
                            break;
                        case '*':value=ope1*ope2;
                            break;
                        case '/':value=ope1/ope2;
                            break;
                        case '%':value=(int)ope1%(int)ope2;
                            break;
                    }
                    push((char)value);
                }
                i++;
            }
            return pop();

        }
    } Infix fix=new Infix();


    @SuppressWarnings("unchecked")
    private void initComponents() {

        display = new javax.swing.JLabel();
        b2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        bdot = new javax.swing.JButton();
        bpm = new javax.swing.JButton();
        backspace = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        brpare = new javax.swing.JButton();
        bplus = new javax.swing.JButton();
        bminus = new javax.swing.JButton();
        bmultiply = new javax.swing.JButton();
        blpare = new javax.swing.JButton();
        bdivide = new javax.swing.JButton();
        bfac = new javax.swing.JButton();
        bsquare = new javax.swing.JButton();
        bxy = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        display2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        display.setBackground(new java.awt.Color(255, 255, 255));
        display.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        display.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        display.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 3));

        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        history.setEditable(false);
        history.setColumns(20);
        history.setRows(5);
        jScrollPane1.setViewportView(history);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORY");

        jButton9.setBackground(new java.awt.Color(255, 102, 102));
        jButton9.setText("CLEAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(67, Short.MAX_VALUE))
                        .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jButton9)
                                .addGap(7, 7, 7))
        );

        b1.setText("1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setText("3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setText("5");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setText("6");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setText("7");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setText("8");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b9.setText("9");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b10.setText("0");
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });

        bdot.setText(".");
        bdot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdotActionPerformed(evt);
            }
        });

        bpm.setText("+/-");
        bpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpmActionPerformed(evt);
            }
        });

        backspace.setText("Backspace");
        backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backspaceActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.setMaximumSize(new java.awt.Dimension(41, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(41, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("=");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        brpare.setText("(");
        brpare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brpareActionPerformed(evt);
            }
        });

        bplus.setText("+");
        bplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bplusActionPerformed(evt);
            }
        });

        bminus.setText("-");
        bminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bminusActionPerformed(evt);
            }
        });

        bmultiply.setText("X");
        bmultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmultiplyActionPerformed(evt);
            }
        });

        blpare.setText(")");
        blpare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blpareActionPerformed(evt);
            }
        });

        bdivide.setText("/");
        bdivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdivideActionPerformed(evt);
            }
        });

        bfac.setText("n!");
        bfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfacActionPerformed(evt);
            }
        });

        bsquare.setText("X^2");
        bsquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsquareActionPerformed(evt);
            }
        });

        bxy.setText("X^Y");
        bxy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxyActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jButton3.setText("sin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("cos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("tan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("log");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("10^x");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("sqrt");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 9, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        display2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        display2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(bpm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(bdot, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(brpare, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(9, 9, 9)
                                                                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(backspace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(9, 9, 9)
                                                                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(5, 5, 5)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(bplus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(bminus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addComponent(bmultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(blpare, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(3, 3, 3)
                                                                        .addComponent(bdivide, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(bsquare, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                                                .addComponent(bfac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(bxy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                        .addComponent(display2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(display2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bplus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bdivide, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(bminus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(bfac, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bmultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bpm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bdot, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(brpare, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(blpare, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(bsquare, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bxy, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b5.getText());
        }
        else
        {
            enternumber=display.getText()+b5.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b5ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b8.getText());
        }
        else
        {
            enternumber=display.getText()+b8.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b8ActionPerformed

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b10ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        if(enternumber==""||enternumber=="0")
        {
            display.setText("0");
        }
        else
        {
            enternumber=display.getText()+b10.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b10ActionPerformed

    private void bmultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmultiplyActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        enternumber1=display2.getText();
        op='*';
        if(enternumber==""&&enternumber1=="")
        {
            display2.setText("0"+"*");

        }
        else if(display.getText()!="")
        {
            if(num2==0)
                num2=1;
            num1=Double.parseDouble(enternumber);
            num2=num1*num2;
            display2.setText(enternumber1+enternumber+"*");
            display.setText("");
        }
        else
        {
            String s;
            int k;
            k=enternumber1.length();
            s=enternumber1.substring(0,k-1);
            char []ch=enternumber1.toCharArray();
            if(ch[k-1]=='(')
                display2.setText(enternumber1);
            else if(ch[k-1]==')'||ch[k-2]=='(')
            {
                display2.setText(enternumber1+"*");
            }
            else
            {
                display2.setText(s+"*");
            }
        }
    }//GEN-LAST:event_bmultiplyActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);
        result=Math.log10(num1);
        display2.setText("log10"+"("+enternumber+")");
        display.setText(""+result);
        history.setText(history.getText()+"log10"+"("+enternumber+")"+"="+result+"\n");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:

        if(display.getText()=="0")
        {
            display.setText(b1.getText());
        }
        else
        {
            enternumber=display.getText()+b1.getText();
            display.setText(enternumber);
        }

    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b2.getText());
        }
        else
        {
            enternumber=display.getText()+b2.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b3.getText());
        }
        else
        {
            enternumber=display.getText()+b3.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b4.getText());
        }
        else
        {
            enternumber=display.getText()+b4.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b6.getText());
        }
        else
        {
            enternumber=display.getText()+b6.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b7.getText());
        }
        else
        {
            enternumber=display.getText()+b7.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b7ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        // TODO add your handling code here:
        if(display.getText()=="0")
        {
            display.setText(b9.getText());
        }
        else
        {
            enternumber=display.getText()+b9.getText();
            display.setText(enternumber);
        }
    }//GEN-LAST:event_b9ActionPerformed

    private void bpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpmActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        int l;
        double n,m;
        n=Double.parseDouble(enternumber);
        l=(int)n;
        m=n-l;
        //  display.setText(""+l+" "+n);

        if(m==0)
        {
            l=l*-1;
            display.setText(""+l);

        }
        else
        {
            n=n*-1;
            display.setText(""+n);
        }

    }//GEN-LAST:event_bpmActionPerformed

    private void bdotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdotActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();

        if(enternumber=="")
        {
            display.setText("0"+".");
        }
        else
        {
            int l;
            double n,m;
            m=Double.parseDouble(enternumber);
            l=(int)m;
            n=(m)-(l);
            if(n==0&&p==0)
            {
                p=1;
                display.setText(enternumber+".");
            }
            else
                display.setText(enternumber);
        }

    }//GEN-LAST:event_bdotActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        display.setText("");
        display2.setText("");
        p=0;
        p_count=0;
        num1=0;
        num2=0;
        result=0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backspaceActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        int p=enternumber.length();
        String sub;
        if(p>1)
        {
            sub=enternumber.substring(0,p-1);
            display.setText(sub);
        }
        else
            display.setText("");
    }//GEN-LAST:event_backspaceActionPerformed

    private void bplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bplusActionPerformed
        // TODO add your handling code here:
        p=0;
        enternumber=display.getText();
        enternumber1=display2.getText();
        op='+';
        if(enternumber==""&&enternumber1=="")
        {
            display2.setText("0"+"+");
            num1=0;
        }
        else if(display.getText()!="")
        {

            num1=Double.parseDouble(enternumber);
            num2=num1+num2;
            display2.setText(enternumber1+enternumber+"+");
            display.setText("");
        }
        else
        {
            String s;
            int k;
            k=enternumber1.length();
            s=enternumber1.substring(0,k-1);
            char []ch=enternumber1.toCharArray();
            if(ch[k-1]=='(')
                display2.setText(enternumber1);
            else if(ch[k-1]==')'||ch[k-2]=='(')
            {
                display2.setText(enternumber1+"+");
            }
            else
            {
                display2.setText(s+"+");
            }

        }
    }//GEN-LAST:event_bplusActionPerformed

    private void bminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bminusActionPerformed

        p=0;// TODO add your handling code here:
        enternumber=display.getText();
        enternumber1=display2.getText();
        op='-';
        if(enternumber==""&&enternumber1=="")
        {
            display2.setText("0"+"-");
            num1=0;
        }
        else if(display.getText()!="")
        {
            num1=Double.parseDouble(enternumber);
            num2=num1-num2;
            display2.setText(enternumber1+enternumber+"-");

            display.setText("");
        }
        else
        {
            String s;
            int k;
            k=enternumber1.length();
            s=enternumber1.substring(0,k-1);
            char []ch=enternumber1.toCharArray();
            if(ch[k-1]=='(')
                display2.setText(enternumber1);
            else if(ch[k-1]==')'||ch[k-2]=='(')
            {
                display2.setText(enternumber1+"-");
            }

            else
            {
                display2.setText(s+"-");
            }
        }
    }//GEN-LAST:event_bminusActionPerformed

    private void bdivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdivideActionPerformed
        // TODO add your handling code here:
        p=0;
        op='/';
        enternumber=display.getText();
        enternumber1=display2.getText();
        if(enternumber==""&&enternumber1=="")
        {
            display2.setText("0"+"/");

        }
        else if(display.getText()!="")
        {
            if(num2==0)
                num2=1;
            num1=Double.parseDouble(enternumber);
            num2=num1/num2;
            display2.setText(enternumber1+enternumber+"/");
            display.setText("");
        }
        else
        {
            String s;
            int k;
            k=enternumber1.length();
            s=enternumber1.substring(0,k-1);
            char []ch=enternumber1.toCharArray();
            if(ch[k-1]=='(')
                display2.setText(enternumber1);
            else if(ch[k-1]==')'||ch[k-2]=='(')
            {
                display2.setText(enternumber1+"/");
            }

            else
            {
                display2.setText(s+"/");
            }
        }
    }//GEN-LAST:event_bdivideActionPerformed

    private void brpareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brpareActionPerformed
        // TODO add your handling code here:
        p_count++;
        enternumber=display2.getText();
        enternumber1=display.getText();
        if(enternumber1=="")
        {
            display2.setText(enternumber+"(");
        }
        else
        {
            display2.setText(enternumber+"("+enternumber1);
            display.setText("");
        }
    }//GEN-LAST:event_brpareActionPerformed

    private void blpareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blpareActionPerformed
        // TODO add your handling code here:

        enternumber=display.getText();
        enternumber1=display2.getText();
        if(p_count>=1)
        {p_count--;
            if(enternumber=="")
            {
                display2.setText(enternumber1+")");
            }
            else
            {
                display2.setText(enternumber1+enternumber+")");
                display.setText("");
            }   }
    }//GEN-LAST:event_blpareActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        p=1;
        enternumber=display2.getText();
        enternumber1=display.getText();
        if(enternumber!="")
        {
            double l;
            l=Double.parseDouble(enternumber1);
            display.setText("");
            display2.setText("");
            if(op=='+')
            {

                result=num2+l-result;
                int lp,lp1;
                lp=(int)Math.ceil(result);
                lp1=(int)Math.floor(result);
                if(lp==lp1)
                    display.setText(""+lp);
                else
                    display.setText(""+result);
                num2=result;
            }
            else if(op=='-')
            {
                result= num2-l+result;
                int lp,lp1;
                lp=(int)Math.ceil(result);
                lp1=(int)Math.floor(result);
                if(lp==lp1)
                    display.setText(""+lp);
                else
                    display.setText(""+result);
                num2=result;
            }
            else if(op=='*')
            {
                if(result!=0)
                    result= (num2*l)/result;
                else
                    result=result= (num2*l);
                int lp,lp1;
                lp=(int)Math.ceil(result);
                lp1=(int)Math.floor(result);
                if(lp==lp1)
                    display.setText(""+lp);
                else
                    display.setText(""+result);

                num2=result;
            }
            else if(op=='/')
            {

                if(result==0)
                    result=1;
                result= (num2/l)*result;
                int lp,lp1;
                lp=(int)Math.ceil(result);
                lp1=(int)Math.floor(result);
                if(lp==lp1)
                    display.setText(""+lp);
                else
                    display.setText(""+result);

                num2=result;
            }
            else if(op=='%')
            {

                result=(num2%l)+result;
                int lp,lp1;
                lp=(int)Math.ceil(result);
                lp1=(int)Math.floor(result);
                if(lp==lp1)
                    display.setText(""+lp);
                else
                    display.setText(""+result);
                display.setText(""+result);
                num2=result;
            }
            else if(op=='^')
            {

                result=Math.pow(num1,l);
                int lp,lp1;
                lp=(int)Math.ceil(result);
                lp1=(int)Math.floor(result);
                if(lp==lp1)
                    display.setText(""+lp);
                else
                    display.setText(""+result);
                display.setText(""+result);
                num1=0;
                l=0;
            }




            history.setText(history.getText()+enternumber+enternumber1+"="+result+"\n");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        history.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void bfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfacActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        double n1=Double.parseDouble(enternumber);
        int l,i,fac=1;
        l=(int)n1;
        double p=n1-l;
        if(l>14)
        {
            display.setText("Overflow");
        }
        else if(p==0&&l>0)
        {
            for(i=l;i>=1;i--)
            {
                fac=fac*i;
            }
            display.setText(""+fac);
            history.setText(history.getText()+"fac"+"("+enternumber+")="+""+fac+"\n");
        }
        else
        {
            display.setText("Factorial not possible");

        }
    }//GEN-LAST:event_bfacActionPerformed

    private void bxyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxyActionPerformed
        // TODO add your handling code here:
        op='^';
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);
        display2.setText(enternumber+ " ^ ");
        display.setText("");
    }//GEN-LAST:event_bxyActionPerformed

    private void bsquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsquareActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);
        result=Math.pow(num1,2);
        display2.setText(enternumber+"^"+2);
        display.setText(""+result);
        history.setText(history.getText()+""+num1+"^"+"2"+"="+result+"\n");

    }//GEN-LAST:event_bsquareActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);
        result=Math.sqrt(num1);
        display2.setText("sqrt"+"("+enternumber+")");
        display.setText(""+result);
        history.setText(history.getText()+"sqrt"+"("+enternumber+")"+"="+result+"\n");

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);
        if(num1<8)
        {
            result=Math.pow(10,num1);
            display2.setText("10"+"^"+num1);
            display.setText(""+result);
            history.setText(history.getText()+""+10+"^"+num1+"="+result+"\n");
        }
        else
            display.setText("OVERFLOW");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);

        display2.setText("tan"+"("+num1+")");
        num2=Math.toRadians(num1);
        result=Math.tan(num2);
        display.setText(""+result);
        history.setText(history.getText()+"tan"+"("+num1+")"+"="+result+"\n");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);

        display2.setText("cos"+"("+num1+")");
        num2=Math.toRadians(num1);
        result=Math.cos(num2);
        display.setText(""+result);
        history.setText(history.getText()+"cos"+"("+num1+")"+"="+result+"\n");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        enternumber=display.getText();
        num1=Double.parseDouble(enternumber);

        display2.setText("sin"+"("+num1+")");
        num2=Math.toRadians(num1);
        result=Math.sin(num2);
        display.setText(""+result);
        history.setText(history.getText()+"sin"+"("+num1+")"+"="+result+"\n");
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calci().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton backspace;
    private javax.swing.JButton bdivide;
    private javax.swing.JButton bdot;
    private javax.swing.JButton bfac;
    private javax.swing.JButton blpare;
    private javax.swing.JButton bminus;
    private javax.swing.JButton bmultiply;
    private javax.swing.JButton bplus;
    private javax.swing.JButton bpm;
    private javax.swing.JButton brpare;
    private javax.swing.JButton bsquare;
    private javax.swing.JButton bxy;
    private javax.swing.JLabel display;
    private javax.swing.JLabel display2;
    private javax.swing.JTextArea history;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
