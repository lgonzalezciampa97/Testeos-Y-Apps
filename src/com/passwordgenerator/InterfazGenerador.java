package com.passwordgenerator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class InterfazGenerador extends JFrame implements ActionListener, AdjustmentListener{
	
	private JLabel lblTitulo, lblSubTitulo, lblValor, lblEstado;
	private JTextField txtContrase�aGenerada, txtAliasGenerado;
	private JButton btnGenerarContrase�a, btnGenerarAlias, btnUsarAlias, btnUsarContrase�a;
	private JScrollBar sBar;
	private JPanel panelBar, panelContrase�a, panelAlias;
	private int posicionBar = Generator.LONGITUD_PASS;
	private String aliasInicial = "", aliasGenerado = "";
	private String passwordInicial="", passwordGenerada = "";
	
	public InterfazGenerador () {
		setLayout(null);
		getContentPane().setBackground(new Color(28,129,90));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("GENERADOR DE CONTRASE�AS SEGURAS Y ALIAS");
		setIconImage(new ImageIcon(getClass().getResource("imgs/passwordLock.png")).getImage()); 
		
		Generator generador = new Generator();
		passwordInicial = generador.generarContrase�a(passwordInicial);
		
		Dictionary diccionario = new Dictionary();
		aliasInicial = diccionario.cargarAlias();
		
		panelAlias = new JPanel();
		panelAlias.setBounds(0,0,800,160);
		panelAlias.setVisible(false);
		panelAlias.setBackground(new Color(28,129,90));
		panelAlias.setLayout(null);
		add(panelAlias);
		
		lblTitulo = new JLabel("GENERADOR DE ALIAS BANCARIO");
		lblTitulo.setFont(new Font("Name Smile",1,24));
		lblTitulo.setForeground(new Color(255,255,255));
		lblTitulo.setBounds(145,10,540,35);
		panelAlias.add(lblTitulo);
		
		lblSubTitulo = new JLabel("GENERE SU ALIAS ALEATORIO");
		lblSubTitulo.setFont(new Font("Hack",1,20));
		lblSubTitulo.setForeground(new Color(192,192,192));
		lblSubTitulo.setBounds(235,35,350,35);
		panelAlias.add(lblSubTitulo);
		
		txtAliasGenerado = new JTextField(aliasInicial);
		txtAliasGenerado.setBounds(10,125,580,30);
		txtAliasGenerado.setFont(new Font("Hack",0,24));
		txtAliasGenerado.setForeground(new Color(255,255,255));
		txtAliasGenerado.setBackground(new Color(28,129,90));
		txtAliasGenerado.setEditable(false);
		panelAlias.add(txtAliasGenerado);
		
		btnGenerarAlias = new JButton("GENERAR");
		btnGenerarAlias.setFont(new Font("Hack",1,18));
		btnGenerarAlias.setForeground(new Color(195,195,195));
		btnGenerarAlias.setBackground(new Color(28,129,90));
		btnGenerarAlias.setBorder(BorderFactory.createRaisedBevelBorder());
		btnGenerarAlias.setBounds(610,125,130,28);
		btnGenerarAlias.addActionListener(this);
		panelAlias.add(btnGenerarAlias);
		
		panelContrase�a = new JPanel();
		panelContrase�a.setBounds(0,0,800,160);
		panelContrase�a.setBackground(new Color(28,129,90));
		panelContrase�a.setLayout(null);
		add(panelContrase�a);
		
		lblTitulo = new JLabel("PROTEJASE  DE  LOS  HACKEOS");
		lblTitulo.setFont(new Font("Name Smile",1,24));
		lblTitulo.setForeground(new Color(255,255,255));
		lblTitulo.setBounds(145,10,500,35);
		panelContrase�a.add(lblTitulo);
		
		lblSubTitulo = new JLabel("USE UNA CONTRASE�A SEGURA");
		lblSubTitulo.setFont(new Font("Hack",1,20));
		lblSubTitulo.setForeground(new Color(192,192,192));
		lblSubTitulo.setBounds(235,35,350,35);
		panelContrase�a.add(lblSubTitulo);
		
		lblValor = new JLabel("Longitud: " + posicionBar);
		lblValor.setFont(new Font("Hack",1,18));
		lblValor.setForeground(new Color(255,255,255));
		lblValor.setBounds(10,95,150,35);
		panelContrase�a.add(lblValor);
		
		lblEstado = new JLabel("CONSTRASE�A SEGURA");
		lblEstado.setBounds(540,125,200,28);
		lblEstado.setFont(new Font("Hack",1,18));
		lblEstado.setForeground(new Color(255,255,255));
		panelContrase�a.add(lblEstado);
		
		txtContrase�aGenerada = new JTextField(passwordInicial);
		txtContrase�aGenerada.setBounds(10,65,580,30);
		txtContrase�aGenerada.setFont(new Font("Hack",0,24));
		txtContrase�aGenerada.setForeground(new Color(255,255,255));
		txtContrase�aGenerada.setBackground(new Color(28,129,90));
		txtContrase�aGenerada.setEditable(false);
		panelContrase�a.add(txtContrase�aGenerada);
		
		btnUsarAlias = new JButton("ALIAS");
		btnUsarAlias.setFont(new Font("Hack",1,18));
		btnUsarAlias.setForeground(new Color(195,195,195));
		btnUsarAlias.setBackground(new Color(28,129,90));
		btnUsarAlias.setBorder(BorderFactory.createRaisedBevelBorder());
		btnUsarAlias.setBounds(10,200,130,28);
		btnUsarAlias.addActionListener(this);
		add(btnUsarAlias);
		
		btnUsarContrase�a = new JButton("CONTRASE�A");
		btnUsarContrase�a.setFont(new Font("Hack",1,18));
		btnUsarContrase�a.setForeground(new Color(195,195,195));
		btnUsarContrase�a.setBackground(new Color(28,129,90));
		btnUsarContrase�a.setBorder(BorderFactory.createRaisedBevelBorder());
		btnUsarContrase�a.setBounds(645,200,130,28);
		btnUsarContrase�a.addActionListener(this);
		add(btnUsarContrase�a);
		
		btnGenerarContrase�a = new JButton("GENERAR");
		btnGenerarContrase�a.setFont(new Font("Hack",1,18));
		btnGenerarContrase�a.setForeground(new Color(195,195,195));
		btnGenerarContrase�a.setBackground(new Color(28,129,90));
		btnGenerarContrase�a.setBorder(BorderFactory.createRaisedBevelBorder());
		btnGenerarContrase�a.setBounds(610,65,130,28);
		btnGenerarContrase�a.addActionListener(this);
		panelContrase�a.add(btnGenerarContrase�a);
		
		panelBar = new JPanel();
		panelBar.setBounds(10,130,500,20);
		panelBar.setBackground(new Color(28,129,90));
		panelBar.setLayout(new BorderLayout());
		panelContrase�a.add(panelBar);
		sBar = new JScrollBar(JScrollBar.HORIZONTAL);
		sBar.setBackground(new Color(28,129,90));
		sBar.setMinimum(4);
		sBar.setMaximum(50);
		sBar.setUnitIncrement(1);
		sBar.setBlockIncrement(10);
		sBar.addAdjustmentListener(this);
		posicionBar = generador.cambiarLongitud(12);
		sBar.setValue(posicionBar);
		panelBar.add(sBar);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getSource() == btnUsarAlias) {
			getContentPane().setBackground(new Color(28,129,90));
			btnUsarAlias.setBackground(new Color(28,129,90));
			btnUsarContrase�a.setBackground(new Color(28,129,90));
			panelContrase�a.setVisible(false);
			panelAlias.setVisible(true);
		}
		else if (evento.getSource() == btnUsarContrase�a) {
			Generator generador = new Generator();
			posicionBar = generador.cambiarLongitud(12);
			sBar.setValue(posicionBar);
			panelContrase�a.setVisible(true);
			panelAlias.setVisible(false);
		}
		
		if (evento.getSource() == btnGenerarContrase�a) {

			txtContrase�aGenerada.setText("");
			
			Generator generador = new Generator();
			generador.cambiarLongitud(posicionBar);
			passwordInicial = generador.generarContrase�a(passwordGenerada);
			
			txtContrase�aGenerada.setText(passwordInicial);
		}
		
		if (evento.getSource() == btnGenerarAlias) {
			aliasInicial = "";
			aliasGenerado = Dictionary.cargarAlias();
			txtAliasGenerado.setText(aliasGenerado);
			
		}
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent evento) {
		posicionBar = evento.getValue();
		lblValor.setText("Lenght: " + evento.getValue());
		Generator generador = new Generator();
		generador.cambiarLongitud(posicionBar);
		passwordInicial = generador.generarContrase�a(passwordGenerada);
		txtContrase�aGenerada.setText(passwordInicial);
		
		if(posicionBar >= 24) {
			getContentPane().setBackground(new Color(6,119,210));
			txtContrase�aGenerada.setBackground(new Color(6,119,210));
			btnGenerarContrase�a.setBackground(new Color(6,119,210));
			panelContrase�a.setBackground(new Color(6,119,210));
			btnUsarAlias.setBackground(new Color(6,119,210));
			btnUsarContrase�a.setBackground(new Color(6,119,210));
			panelBar.setBackground(new Color(6,119,210));
			sBar.setBackground(new Color(6,119,210));
			lblValor.setText("Longitud: " + posicionBar);
			lblEstado.setText("�CONSTRASE�A ANTI-HACK!");
			lblEstado.setBounds(520,125,280,28);
		}
		else if(posicionBar >= 12) {
			getContentPane().setBackground(new Color(28,129,90));
			txtContrase�aGenerada.setBackground(new Color(28,129,90));
			btnGenerarContrase�a.setBackground(new Color(28,129,90));
			panelContrase�a.setBackground(new Color(28,129,90));
			btnUsarAlias.setBackground(new Color(28,129,90));
			btnUsarContrase�a.setBackground(new Color(28,129,90));
			panelBar.setBackground(new Color(28,129,90));
			sBar.setBackground(new Color(28,129,90));
			lblValor.setText("Longitud: " + posicionBar);
			lblEstado.setText("CONSTRASE�A SEGURA");
			lblEstado.setBounds(540,125,200,28);
		}
		else if(posicionBar > 6 && posicionBar < 12) {
			getContentPane().setBackground(new Color(190,78,58));
			txtContrase�aGenerada.setBackground(new Color(190,78,58));
			btnGenerarContrase�a.setBackground(new Color(190,78,58));
			panelContrase�a.setBackground(new Color(190,78,58));
			btnUsarAlias.setBackground(new Color(190,78,58));
			btnUsarContrase�a.setBackground(new Color(190,78,58));
			panelBar.setBackground(new Color(190,78,58));
			sBar.setBackground(new Color(190,78,58));
			lblValor.setText("Longitud: " + posicionBar);
			lblEstado.setText("CONSTRASE�A CASI SEGURA");
			lblEstado.setBounds(520,125,280,28);
		}
		else if (posicionBar <= 6) {
			getContentPane().setBackground(new Color(209,54,78));
			txtContrase�aGenerada.setBackground(new Color(209,54,78));
			btnGenerarContrase�a.setBackground(new Color(209,54,78));
			panelContrase�a.setBackground(new Color(209,54,78));
			btnUsarAlias.setBackground(new Color(209,54,78));
			btnUsarContrase�a.setBackground(new Color(209,54,78));
			panelBar.setBackground(new Color(209,54,78));
			sBar.setBackground(new Color(209,54,78));
			lblValor.setText("Longitud: " + posicionBar);
			lblEstado.setText("CONSTRASE�A DEBIL");
			lblEstado.setBounds(540,125,200,28);
		}
		
	}

	
	public static void main(String[] args) {
		
		InterfazGenerador ventana = new InterfazGenerador();
		ventana.setBounds(0,0,800,280);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setVisible(true);
	}




}
