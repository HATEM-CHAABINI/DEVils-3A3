<?php

namespace BibliothequeBundle\Controller;

use BibliothequeBundle\Entity\CommentaireLivre;
use BibliothequeBundle\Entity\Livre;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\Request;

/**
 * Commentairelivre controller.
 *
 * @Route("commentairelivre")
 */
class CommentaireLivreController extends Controller
{

    /**
     * Lists all commentaireLivre entities.
     *
     * @Route("/deleteComm/{id}", name="comm_delete")
     * @Method("GET")
     */
    public function commDeleteAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $commentaireLivre = $em->getRepository('BibliothequeBundle:CommentaireLivre')->find($id);

        $em = $this->getDoctrine()->getManager();
        $em->remove($commentaireLivre);
        $em->flush();
        return $this->redirectToRoute('livre_commenter', array('id' => $commentaireLivre->getLivre()));
    }

    /**
     * Lists all commentaireLivre entities.
     *
     * @Route("/", name="commentairelivre_index")
     * @Method("GET")
     */
    public
    function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $commentaireLivres = $em->getRepository('BibliothequeBundle:CommentaireLivre')->findAll();

        return $this->render('commentairelivre/index.html.twig', array(
            'commentaireLivres' => $commentaireLivres,
        ));
    }


    /**
     * Creates a new commentaireLivre entity.
     *
     * @Route("/new", name="commentairelivre_new")
     * @Method({"GET", "POST"})
     */
    public
    function newAction(Request $request)
    {
        $commentaireLivre = new Commentairelivre();
        $form = $this->createForm('BibliothequeBundle\Form\CommentaireLivreType', $commentaireLivre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($commentaireLivre);
            $em->flush();

            return $this->redirectToRoute('commentairelivre_show', array('id' => $commentaireLivre->getId()));
        }

        return $this->render('commentairelivre/new.html.twig', array(
            'commentaireLivre' => $commentaireLivre,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a commentaireLivre entity.
     *
     * @Route("/{id}", name="commentairelivre_show")
     * @Method("GET")
     */
    public
    function showAction(CommentaireLivre $commentaireLivre)
    {
        $deleteForm = $this->createDeleteForm($commentaireLivre);

        return $this->render('commentairelivre/show.html.twig', array(
            'commentaireLivre' => $commentaireLivre,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing commentaireLivre entity.
     *
     * @Route("/{id}/edit", name="commentairelivre_edit")
     * @Method({"GET", "POST"})
     */
    public
    function editAction(Request $request, CommentaireLivre $commentaireLivre)
    {
        $deleteForm = $this->createDeleteForm($commentaireLivre);
        $editForm = $this->createForm('BibliothequeBundle\Form\CommentaireLivreType', $commentaireLivre);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('commentairelivre_edit', array('id' => $commentaireLivre->getId()));
        }

        return $this->render('commentairelivre/edit.html.twig', array(
            'commentaireLivre' => $commentaireLivre,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a commentaireLivre entity.
     *
     * @Route("/{id}", name="commentairelivre_delete")
     * @Method("DELETE")
     */
    public
    function deleteAction(Request $request, CommentaireLivre $commentaireLivre)
    {
        $form = $this->createDeleteForm($commentaireLivre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($commentaireLivre);
            $em->flush();
        }

        return $this->redirectToRoute('commentairelivre_index');
    }


    /**
     * Creates a form to delete a commentaireLivre entity.
     *
     * @param CommentaireLivre $commentaireLivre The commentaireLivre entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private
    function createDeleteForm(CommentaireLivre $commentaireLivre)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('commentairelivre_delete', array('id' => $commentaireLivre->getId())))
            ->setMethod('DELETE')
            ->getForm();
    }
}
