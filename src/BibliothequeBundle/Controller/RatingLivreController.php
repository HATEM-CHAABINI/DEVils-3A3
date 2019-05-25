<?php

namespace BibliothequeBundle\Controller;

use BibliothequeBundle\Entity\RatingLivre;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;use Symfony\Component\HttpFoundation\Request;

/**
 * Ratinglivre controller.
 *
 * @Route("ratinglivre")
 */
class RatingLivreController extends Controller
{
    /**
     * Lists all ratingLivre entities.
     *
     * @Route("/", name="ratinglivre_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $ratingLivres = $em->getRepository('BibliothequeBundle:RatingLivre')->findAll();

        return $this->render('ratinglivre/index.html.twig', array(
            'ratingLivres' => $ratingLivres,
        ));
    }

    /**
     * Creates a new ratingLivre entity.
     *
     * @Route("/new", name="ratinglivre_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $ratingLivre = new Ratinglivre();
        $form = $this->createForm('BibliothequeBundle\Form\RatingLivreType', $ratingLivre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($ratingLivre);
            $em->flush();

            return $this->redirectToRoute('ratinglivre_show', array('id' => $ratingLivre->getId()));
        }

        return $this->render('ratinglivre/new.html.twig', array(
            'ratingLivre' => $ratingLivre,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a ratingLivre entity.
     *
     * @Route("/{id}", name="ratinglivre_show")
     * @Method("GET")
     */
    public function showAction(RatingLivre $ratingLivre)
    {
        $deleteForm = $this->createDeleteForm($ratingLivre);

        return $this->render('ratinglivre/show.html.twig', array(
            'ratingLivre' => $ratingLivre,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing ratingLivre entity.
     *
     * @Route("/{id}/edit", name="ratinglivre_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, RatingLivre $ratingLivre)
    {
        $deleteForm = $this->createDeleteForm($ratingLivre);
        $editForm = $this->createForm('BibliothequeBundle\Form\RatingLivreType', $ratingLivre);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('ratinglivre_edit', array('id' => $ratingLivre->getId()));
        }

        return $this->render('ratinglivre/edit.html.twig', array(
            'ratingLivre' => $ratingLivre,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a ratingLivre entity.
     *
     * @Route("/{id}", name="ratinglivre_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, RatingLivre $ratingLivre)
    {
        $form = $this->createDeleteForm($ratingLivre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($ratingLivre);
            $em->flush();
        }

        return $this->redirectToRoute('ratinglivre_index');
    }

    /**
     * Creates a form to delete a ratingLivre entity.
     *
     * @param RatingLivre $ratingLivre The ratingLivre entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(RatingLivre $ratingLivre)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('ratinglivre_delete', array('id' => $ratingLivre->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
